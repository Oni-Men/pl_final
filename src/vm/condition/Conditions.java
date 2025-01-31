package vm.condition;

import java.util.HashSet;
import java.util.Set;

import parser.ast.Cell;
import util.Bool;
import util.Cond;
import vm.SymbolTable;
import vm.exception.VMError;
import vm.pobject.PSet;
import vm.pobject.PVariable;

/**
 * 条件
 */
public class Conditions implements IEvaluable
{
  public static Conditions of(Cell conditions)
  {
    // 条件の種類を求める
    String logicType = conditions.head().text();
    Conditions result = Cond
        .whenText(
            (s) -> s.equalsIgnoreCase("and"),
            () -> handleConjunction(conditions.tail()))
        .or(
            (s) -> s.equalsIgnoreCase("or"),
            () -> handleDisjunction(conditions.tail()))
        .get(logicType, null);

    Bool.isNull(result).throwIfTrue(() -> new VMError("Invalid condition"));
    return result;
  }

  /**
   * 連言（AND）の処理を行う
   * 
   * @return
   */
  private static Conditions handleConjunction(Cell conjunction)
  {
    IEvaluable evaluable1 = IEvaluable.of(conjunction.head());
    IEvaluable evaluable2 = IEvaluable.of(conjunction.next());

    return new Conditions(ConditionType.AND, evaluable1, evaluable2);
  }

  /**
   * 選言（OR）の処理を行う
   * 
   * @return
   */
  private static Conditions handleDisjunction(Cell disjunction)
  {
    IEvaluable evaluable1 = IEvaluable.of(disjunction.head());
    IEvaluable evaluable2 = IEvaluable.of(disjunction.next());

    return new Conditions(ConditionType.OR, evaluable1, evaluable2);
  }

  public enum ConditionType
  {
    AND, OR
  }

  private ConditionType operator;
  private IEvaluable firstEvaluable;
  private IEvaluable secondEvaluable;

  public Conditions(ConditionType operator, IEvaluable firstEvaluable, IEvaluable secondEvaluable)
  {
    this.operator = operator;
    this.firstEvaluable = firstEvaluable;
    this.secondEvaluable = secondEvaluable;
  }

  public EvaluateResult evaluate(String elementName, SymbolTable symbolTable)
  {
    SymbolTable currentScope = symbolTable.fork();

    // 右項（第二項）から評価する
    EvaluateResult secondResult = secondEvaluable.evaluate(elementName, symbolTable);
    currentScope.put(secondResult.variableName, secondResult.generatedSet);

    // 続いて左項を評価
    EvaluateResult firstResult = firstEvaluable.evaluate(elementName, currentScope);

    String variableName = "__" + elementName;

    // 左項と右項の変数名が同じときはAND，ORに応じて集合演算
    if (firstResult.variableName.equals(secondResult.variableName))
    {
      PSet generatedSet = Cond
          .when(ConditionType.AND, () -> firstResult.generatedSet.intersect(secondResult.generatedSet))
          .or(ConditionType.OR, () -> firstResult.generatedSet.union(secondResult.generatedSet))
          .get(operator, null);

      currentScope.put(variableName, generatedSet);

      Bool status = Cond
          .when(ConditionType.AND, () -> firstResult.satisfied().and(secondResult.satisfied()))
          .or(ConditionType.OR, () -> firstResult.satisfied().or(secondResult.satisfied()))
          .get(operator, Bool.of(false));
      Bool noFreeVariables = firstResult.noFreeVariables().and(secondResult.noFreeVariables());

      return new EvaluateResult(variableName, generatedSet, status, noFreeVariables, currentScope);
    }

    // AND演算の場合は左項によって生成される集合が選ばれる
    if (operator == ConditionType.AND)
    {
      currentScope.put(variableName, firstResult.generatedSet);
      return new EvaluateResult(variableName, firstResult.generatedSet,
          firstResult.satisfied, firstResult.noFreeVariables, currentScope);
    }

    // OR演算がくると結果が不定になる
    throw new VMError();
  }

  @Override
  public Set<PVariable> freeVariables()
  {
    Set<PVariable> freePVariables1 = this.firstEvaluable.freeVariables();
    Set<PVariable> freePVariables2 = this.firstEvaluable.freeVariables();
    Set<PVariable> freePVariables = new HashSet<>();
    freePVariables.addAll(freePVariables1);
    freePVariables.addAll(freePVariables2);

    return freePVariables;
  }
}

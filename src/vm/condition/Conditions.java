package vm.condition;

import parser.ast.Cell;
import util.Bool;
import util.Cond;
import vm.SymbolTable;
import vm.exception.VMException;
import vm.pobject.PSet;

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

    Bool.isNull(result).throwIfTrue(() -> new VMException("Invalid condition"));
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

  public EvaluateResult evaluate(SymbolTable symbolTable)
  {
    SymbolTable currentScope = symbolTable.fork();

    // 右項（第二項）から評価する
    EvaluateResult secondResult = secondEvaluable.evaluate(symbolTable);
    currentScope.put(secondResult.variableName, secondResult.generatedSet);

    // 続いて左項を評価
    EvaluateResult firstResult = firstEvaluable.evaluate(currentScope);

    // 結果の変数名は左項（第一項）のものを流用する
    String variableName = firstResult.variableName;

    // 左項と右項の変数名が同じときはAND，ORに応じて集合演算
    if (firstResult.variableName.equals(secondResult.variableName))
    {
      PSet generatedSet = Cond
          .when(ConditionType.AND, () -> firstResult.generatedSet.intersect(secondResult.generatedSet))
          .or(ConditionType.OR, () -> firstResult.generatedSet.union(secondResult.generatedSet))
          .get(operator, null);

      currentScope.put(variableName, generatedSet);
      return new EvaluateResult(variableName, generatedSet, currentScope);
    }

    // AND演算の場合は左項によって生成される集合が選ばれる
    if (operator == ConditionType.AND)
    {
      currentScope.put(variableName, firstResult.generatedSet);
      return new EvaluateResult(variableName, firstResult.generatedSet, currentScope);
    }

    // OR演算がくると結果が不定になる
    throw new VMException();
  }

}

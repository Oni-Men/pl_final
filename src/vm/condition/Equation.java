package vm.condition;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import util.Bool;
import vm.SymbolTable;
import vm.exception.VMException;
import vm.expression.MathExpression;
import vm.expression.ValueExpression;
import vm.pobject.PSet;
import vm.pobject.PValue;
import vm.pobject.PVariable;

public class Equation extends Relation
{

  private MathExpression leftExpression;
  private MathExpression rightExpression;

  public Equation(MathExpression leftExpression, MathExpression rightExpression)
  {
    this.leftExpression = leftExpression;
    this.rightExpression = rightExpression;
  }

  @Override
  public EvaluateResult evaluate(String elementName, SymbolTable scope)
  {
    Set<PVariable> leftFreeVariables = leftExpression.freeVariables();
    Set<PVariable> rightFreeVariables = rightExpression.freeVariables();

    List<PVariable> freeVariables = Stream.concat(leftFreeVariables.stream(), rightFreeVariables.stream())
        .distinct()
        .toList();

    EvaluateResult result = doEvaluate(elementName, scope, freeVariables, leftExpression, rightExpression);
    return result;
  }

  private EvaluateResult doEvaluate(String elementName, SymbolTable scope, List<PVariable> freeVariables,
      MathExpression leftExpressoin, MathExpression righExpression)
  {
    if (freeVariables.isEmpty())
    {
      PValue leftValue = leftExpressoin.evaluate(scope);
      PValue rightValue = rightExpression.evaluate(scope);
      Bool equal = Bool.of(leftValue.equals(rightValue));
      return Bool.of(elementName.equals("$"))
          .ifTrueElse(
              () -> new EvaluateResult(elementName, PSet.PHI, equal, Bool.of(true), scope),
              () -> {
                PSet pset = equal
                    .ifTrueElse(
                        () -> new PSet(scope.getAsValue(elementName)),
                        () -> PSet.PHI);
                return new EvaluateResult(elementName, pset, equal, Bool.of(true), scope);
              });
    }
    else
    {
      // 自由変数を一つ束縛変数にする
      // 束縛できない変数は一つだけに限られる

      // 束縛できる自由変数を一つみつける
      PVariable freeVariable = freeVariables.stream()
          .filter(v -> scope.getAsSet("__" + v.getSymbolName()) != null)
          .findFirst().orElse(null);

      if (freeVariable == null)
      {
        // 束縛できる変数が存在しなかった場合
        Set<PVariable> leftFreeVariables = leftExpression.freeVariables(scope);
        Set<PVariable> rightFreeVariables = rightExpression.freeVariables(scope);
        List<PVariable> freeVariablesWithScope = Stream.concat(leftFreeVariables.stream(), rightFreeVariables.stream())
            .distinct()
            .toList();

        // 左右合わせて不定な変数は一つのみ．
        Bool.of(freeVariablesWithScope.size() != 1).throwIfTrue(() -> new VMException("無効な等式(不定な変数はたかだか1つ)"));

        // 不定な変数は左右の片方
        Bool leftIndefinite = Bool.of(leftFreeVariables.size() == 1).and(rightFreeVariables.size() == 0);
        Bool rightIndefinite = Bool.of(leftFreeVariables.size() == 0).and(rightFreeVariables.size() == 1);
        leftIndefinite.or(rightIndefinite).not().throwIfTrue(() -> new VMException("無効な等式(不定な変数が両辺に存在)"));

        MathExpression definiteExpression = leftIndefinite.ifTrueElse(() -> righExpression, () -> leftExpressoin);
        MathExpression indefiniteExpression = leftIndefinite.ifTrueElse(() -> leftExpressoin, () -> rightExpression);

        // 不定な式は変数のみの式でなければならない．（x + 1）とかはだめ
        Bool.of(indefiniteExpression instanceof ValueExpression).not()
            .ifTrue(() -> new VMException("無効な等式(不定な変数をふくむ式)"));

        String indefiniteVariableName = freeVariablesWithScope.getFirst().getSymbolName();
        Bool.of(!indefiniteVariableName.equals(elementName))
            .and(!elementName.equals("$"))
            .throwIfTrue(() -> new VMException("不定な変数が集合の要素変数ではありません"));

        PValue value = definiteExpression.evaluate(scope);
        return new EvaluateResult(elementName, new PSet(value), Bool.of(false), scope);
      }
      else
      {
        // 変数を束縛できる場合
        // 束縛する変数を自由変数のリストから削除
        List<PVariable> nextfreeVariables = freeVariables.stream()
            .filter(v -> !v.equals(freeVariable))
            .toList();
        PSet target = new PSet();
        PSet domain = scope.getAsSet("__" + freeVariable.getSymbolName());
        Bool status = Bool.of(false);
        Bool noFreeVariables = Bool.of(true);
        for (PValue pValue : domain.values())
        {
          SymbolTable forked = scope.fork();
          forked.put(freeVariable.getSymbolName(), pValue);
          EvaluateResult evaluated = doEvaluate(elementName, forked, nextfreeVariables,
              leftExpressoin, rightExpression);
          target = target.union(evaluated.generatedSet);
          status = status.or(evaluated.status);
          noFreeVariables = noFreeVariables.and(evaluated.noFreeVariables);
        }
        return new EvaluateResult(elementName, target, status, noFreeVariables, scope);
      }
    }
  }

  @Override
  public Set<PVariable> freeVariables()
  {
    Set<PVariable> freeVariables = new HashSet<>();
    freeVariables.addAll(this.leftExpression.freeVariables());
    freeVariables.addAll(this.rightExpression.freeVariables());

    return freeVariables;
  }
}

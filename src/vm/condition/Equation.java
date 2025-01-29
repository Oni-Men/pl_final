package vm.condition;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.Bool;
import vm.SymbolTable;
import vm.exception.PSetException;
import vm.exception.VMException;
import vm.expression.MathExpression;
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
  public EvaluateResult evaluate(SymbolTable scope)
  {
    Set<PVariable> leftFreeVariables = leftExpression.freeVariables();
    Set<PVariable> rightFreeVariables = rightExpression.freeVariables();

    Bool.of(leftFreeVariables.size() != 1).throwIfTrue(() -> new VMException("左辺の変数は，ただ一つでなくてはならない"));
    PVariable leftFreeVariable = leftFreeVariables.iterator().next();

    String variableName = "__" + leftFreeVariable.getSymbolName();
    PSet targetSet = doEvaluate(scope, rightFreeVariables.stream().toList(), rightExpression);
    return new EvaluateResult(variableName, targetSet, Bool.of(false), scope);
  }

  private PSet doEvaluate(SymbolTable scope, List<PVariable> freeVariables, MathExpression expression)
  {
    if (freeVariables.isEmpty())
    {
      return new PSet(expression.evaluate(scope));
    }
    else
    {
      PVariable freeVariable = freeVariables.getFirst();
      freeVariables = freeVariables.stream().skip(1).toList();
      PSet domain = scope.getAsSet("__" + freeVariable.getSymbolName());
      Bool.of(domain == null).throwIfTrue(() -> new PSetException());

      PSet target = new PSet();
      for (PValue pValue : domain.values())
      {
        SymbolTable forked = scope.fork();
        forked.put(freeVariable.getSymbolName(), pValue);
        PSet evaluated = doEvaluate(forked, freeVariables, expression);
        target = target.union(evaluated);
      }
      return target;
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

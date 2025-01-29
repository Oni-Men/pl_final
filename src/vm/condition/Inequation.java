package vm.condition;

import java.util.HashSet;
import java.util.Set;

import parser.ast.TokenType;
import vm.expression.MathExpression;
import vm.pobject.PVariable;

public class Inequation extends Relation
{

  private TokenType operator;
  private MathExpression leftExpression;
  private MathExpression rightExpression;

  public Inequation(TokenType operator, MathExpression leftExpression, MathExpression rightExpression)
  {
    this.operator = operator;
    this.leftExpression = leftExpression;
    this.rightExpression = rightExpression;
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

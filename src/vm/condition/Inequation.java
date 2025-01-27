package vm.condition;

import parser.ast.TokenType;
import vm.expression.MathExpression;

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

}

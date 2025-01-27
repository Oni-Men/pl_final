package vm.condition;

import util.Bool;
import vm.expression.MathExpression;
import vm.pobject.PValue;

public class Equation extends Relation
{

  private Bool not;
  private MathExpression leftExpression;
  private MathExpression rightExpression;

  public Equation(MathExpression leftExpression, MathExpression rightExpression)
  {
    this.leftExpression = leftExpression;
    this.rightExpression = rightExpression;
  }

  public Equation(MathExpression leftExpression, MathExpression rightExpression, boolean not)
  {
    this(leftExpression, rightExpression);
    this.not = Bool.of(not);
  }

  public PValue evaluate()
  {
    return null;
  }

}

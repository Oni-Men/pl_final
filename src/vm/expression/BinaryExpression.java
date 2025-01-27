package vm.expression;

import static parser.ast.TokenType.*;

import parser.ast.TokenType;
import util.Cond;
import vm.SymbolTable;
import vm.pobject.PValue;

public class BinaryExpression extends MathExpression
{

  private TokenType operator;
  private MathExpression firstOperand;
  private MathExpression secondOperand;

  public BinaryExpression(TokenType operator, MathExpression firstOperand, MathExpression secondOperand)
  {
    this.operator = operator;
    this.firstOperand = firstOperand;
    this.secondOperand = secondOperand;
  }

  @Override
  public PValue evaluate(SymbolTable scope)
  {
    PValue first = this.firstOperand.evaluate(scope);
    PValue second = this.secondOperand.evaluate(scope);

    return Cond
        .when(PLUS, () -> first.add(second))
        .or(MINUS, () -> first.subtract(second))
        .or(MULTIPLY, () -> first.multiply(second))
        .or(DIVIDE, () -> first.divide(second))
        .or((_) -> true, () -> {
          throw new RuntimeException("Invalid operation");
        }).get(this.operator, null);
  }
}

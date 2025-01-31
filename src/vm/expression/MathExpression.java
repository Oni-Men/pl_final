package vm.expression;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import parser.ast.Cell;
import parser.ast.Leaf;
import parser.ast.Token;
import parser.ast.TokenType;
import util.Bool;
import vm.SymbolTable;
import vm.pobject.PValue;
import vm.pobject.PVariable;

import static parser.ast.TokenType.*;

public class MathExpression
{
  private static final Set<TokenType> AllowedToken = new HashSet<>();
  static
  {
    AllowedToken.addAll(Arrays.asList(
        PLUS, MINUS, MULTIPLY, DIVIDE, ID, NUMBER, REAL));
  };

  public static MathExpression of(Cell cell)
  {
    Token operator = cell.head().<Leaf>as().token();
    Cell operand = cell.tail();

    if (!AllowedToken.contains(operator.tokenType()))
    {
      throw new RuntimeException("Invalid operator in expression");
    }

    Bool isValue = Bool.of(operator.tokenType() == ID)
        .or(operator.tokenType() == NUMBER)
        .or(operator.tokenType() == REAL);

    return isValue.ifTrueElse(
        () -> valueExpression(operand),
        () -> binaryExpression(operator.tokenType(), operand));
  }

  private static MathExpression valueExpression(Cell cell)
  {
    Token token = cell.head().<Leaf>as().token();
    return new ValueExpression(token);
  }

  private static MathExpression binaryExpression(TokenType operator, Cell cell)
  {
    Cell firstCell = cell.head();
    Cell secondCell = cell.next();

    MathExpression firstExpression = MathExpression.of(firstCell);
    MathExpression secondExpression = MathExpression.of(secondCell);
    return new BinaryExpression(operator, firstExpression, secondExpression);
  }

  public PValue evaluate(SymbolTable scope)
  {
    throw new RuntimeException("Invalid operation");
  }

  public Set<PVariable> freeVariables()
  {
    return Collections.emptySet();
  }

  public Set<PVariable> freeVariables(SymbolTable symbolTable)
  {
    return Collections.emptySet();
  }
}

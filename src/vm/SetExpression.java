package vm;

import static parser.ast.TokenType.MINUS;
import static parser.ast.TokenType.MULTIPLY;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import parser.ast.Cell;
import parser.ast.Leaf;
import parser.ast.Token;
import parser.ast.TokenType;
import util.Bool;
import util.Cond;
import vm.exception.VMException;
import vm.pobject.PSet;

import static parser.ast.TokenType.*;

public class SetExpression
{
  private static final Set<TokenType> OperatorTypes = new HashSet<>();
  static
  {
    OperatorTypes.addAll(Arrays.asList(PLUS, MINUS, MULTIPLY, EXCLUSIVE, ID));
  };

  public static SetExpression of(Cell cell)
  {
    Token operator = cell.head().<Leaf>as().token();
    Cell operand = cell.tail();

    if (OperatorTypes.contains(operator.tokenType()))
    {
      if (operator.tokenType() == ID)
      {
        String operatorName = operator.text();
        SetExpression expression = Cond
            .when(
                (String s) -> s.equalsIgnoreCase("domlimmitedset"),
                () -> domainLimitedSet(operand))
            .or(
                (String _) -> true,
                () -> variableSet(operand))
            .get(operatorName, null);

        Bool.of(expression == null).throwIfTrue(() -> new VMException("Invalid expression"));
        return expression;
      }
      else
      {
        SetExpression firstExpression = SetExpression.of(operand.head());
        SetExpression secondExpression = SetExpression.of(operand.next());

        return new SetBinaryExpression(operator, firstExpression, secondExpression);
      }
    }

    throw new VMException("Invalid expression");
  }

  private static SetExpression domainLimitedSet(Cell cell)
  {
    String domainName = cell.head().next().text();
    Cell domainLimiter = cell.next();
    Cell range = domainLimiter.next();

    Number lowerBound = toNumber(range.next());
    Number upperBound = toNumber(range.tail().next());

    Number step = toNumber(domainLimiter.tail().next());

    return new SetDomainLimitExpression(domainName, lowerBound, upperBound, step);
  }

  private static SetExpression variableSet(Cell cell)
  {
    String setName = cell.head().text();
    return new SetVariableExpression(setName);
  }

  private static Number toNumber(Cell cell)
  {
    String type = cell.head().text();
    return Cond
        .when((String s) -> s.equalsIgnoreCase("integer"), () -> {
          return (Number) Long.valueOf(cell.next().text());
        })
        .or((String s) -> s.equalsIgnoreCase("real"), () -> {
          return (Number) Double.valueOf(cell.next().text());
        })
        .get(type, null);
  }

  public PSet evaluate(SymbolTable symbolTable)
  {
    throw new RuntimeException("Expression not implemented");
  }
}

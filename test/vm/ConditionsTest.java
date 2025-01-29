package vm;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static parser.ast.TokenType.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import parser.Parser;
import parser.ast.Cell;
import parser.ast.Token;
import vm.condition.Conditions;
import vm.condition.Equation;
import vm.condition.Inclusion;
import vm.condition.Conditions.ConditionType;
import vm.expression.BinaryExpression;
import vm.expression.ValueExpression;
import vm.pobject.PInteger;
import vm.pobject.PSet;
import vm.pobject.PValue;

public class ConditionsTest
{

  @ParameterizedTest
  @MethodSource("testCaseProvider")
  void testConditoins(SymbolTable symbolTable, Conditions conditions, PSet expectedSet)
  {
    var result = conditions.evaluate(symbolTable);
    var actualSet = result.symbolTable().getAsSet(result.variableName());
    assertEquals(expectedSet, actualSet);
  }

  private static Stream<Arguments> testCaseProvider()
  {
    return Stream.of(
        testCase00(),
        testCase01());
  }

  private static Arguments testCase00()
  {
    SymbolTable symbolTable = new SymbolTable();
    symbolTable.put("A", fromIntegres(0, 1, 2, 3));

    // x = 2 * y + 1
    var equation = new Equation(
        new ValueExpression(new Token(ID, "x")),
        new BinaryExpression(PLUS,
            new BinaryExpression(MULTIPLY,
                new ValueExpression(new Token(NUMBER, "2")),
                new ValueExpression(new Token(ID, "y"))),
            new ValueExpression(new Token(NUMBER, "1"))));

    // y ~ A
    var notationA = "(EXPRESSION (UPPER_ID A))";
    var inclusion = new Inclusion("y", notation(notationA));

    Conditions conditions = new Conditions(ConditionType.AND, equation, inclusion);
    PSet expectedSet = fromIntegres(1, 3, 5, 7);

    return arguments(symbolTable, conditions, expectedSet);
  }

  private static Arguments testCase01()
  {
    SymbolTable symbolTable = new SymbolTable();
    symbolTable.put("A", fromIntegres(1, 3, 5, 7));
    symbolTable.put("B", fromIntegres(2, 3, 4, 5));

    var equation1 = new Equation(
        new ValueExpression(new Token(ID, "x")),
        new BinaryExpression(PLUS,
            new BinaryExpression(MULTIPLY,
                new ValueExpression(new Token(NUMBER, "2")),
                new ValueExpression(new Token(ID, "y"))),
            new BinaryExpression(MULTIPLY,
                new ValueExpression(new Token(NUMBER, "3")),
                new ValueExpression(new Token(ID, "z")))));

    var equation2 = new Equation(
        new ValueExpression(new Token(ID, "x")),
        new BinaryExpression(PLUS,
            new BinaryExpression(MULTIPLY,
                new ValueExpression(new Token(NUMBER, "3")),
                new ValueExpression(new Token(ID, "y"))),
            new BinaryExpression(MULTIPLY,
                new ValueExpression(new Token(NUMBER, "4")),
                new ValueExpression(new Token(ID, "z")))));

    String notationA = "(EXPRESSION (UPPER_ID A))";
    String notationB = "(EXPRESSION (UPPER_ID B))";
    var inclusion1 = new Inclusion("y", notation(notationA));
    var inclusion2 = new Inclusion("z", notation(notationB));

    Conditions conditions = new Conditions(ConditionType.AND,
        new Conditions(ConditionType.AND,
            new Conditions(ConditionType.AND,
                equation1,
                equation2),
            inclusion1),
        inclusion2);
    PSet expectedSet = fromIntegres(11, 15, 17, 19, 21, 23, 25, 29);
    return arguments(symbolTable, conditions, expectedSet);
  }

  static Cell notation(String inputString)
  {
    Cell notation = new Parser(inputString).parse().get(0);
    return notation;
  }

  static PSet fromIntegres(Integer... values)
  {
    PValue[] pValues = new PValue[values.length];
    for (int i = 0; i < pValues.length; i++)
    {
      pValues[i] = new PInteger(values[i]);
    }
    return new PSet(pValues);
  }
}

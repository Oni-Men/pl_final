package vm;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import parser.Parser;
import parser.Scanner;
import parser.ast.Node;

public class EvaluatorTest
{

  @ParameterizedTest
  @MethodSource("testCaseProvider")
  void testEvaluator(Node statement, SymbolTable environment, String expectedOutput, String expectedEnvironment)
  {
    var evaluator = new Evaluator(statement, environment);
    evaluator.perform();

    assertEquals(expectedOutput, evaluator.output());
    assertEquals(expectedEnvironment.strip(), evaluator.environment().toString().strip());
  }

  private static Stream<Arguments> testCaseProvider()
  {
    return Stream.of(testCase01(), testCase02(), testCase03());
  }

  /**
   * 外延表記のテスト
   * 
   * @return
   */
  private static Arguments testCase01()
  {
    String inputString = """
        (ASSERT (UPPER_ID A_set)
            (EXTENSION
                (SETELEMENTS
                    (SETELEMENT (INTEGER -3))
                    (SETELEMENT (INTEGER 4))
                    (SETELEMENT (INTEGER 11)))))
            """;
    Node statement = new Parser(new Scanner(inputString)).parse().get(0);
    SymbolTable environment = new SymbolTable();
    String expectedOutput = "";
    String expectedEnvironment = "A_set: {-3,4,11}";
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

  /**
   * 内包表記のテスト
   * 
   * @return
   */
  private static Arguments testCase02()
  {
    String inputString = """
        (ASSERT (UPPER_ID A_set)
        (INTENSION
            (SETELEMENT (LOWER_ID x))
            (AND
                (= (LOWER_ID x)
                    (* (INTEGER 2) (LOWER_ID y)))
                (~
                    (SETELEMENT (LOWER_ID y))
                    (EXPRESSION (UPPER_ID X))))))
            """;
    Node statement = new Parser(new Scanner(inputString)).parse().get(0);
    SymbolTable environment = new SymbolTable();
    String expectedOutput = "";
    String expectedEnvironment = "";
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

  /**
   * 集合演算のテスト
   * 
   * @return
   */
  private static Arguments testCase03()
  {
    String inputString = """
        (ASSERT (UPPER_ID A)
            (EXPRESSION
                (+ (UPPER_ID B) (UPPER_ID C))))
                """;
    Node statement = new Parser(new Scanner(inputString)).parse().get(0);
    SymbolTable environment = new SymbolTable();
    String expectedOutput = "";
    String expectedEnvironment = "";
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

}

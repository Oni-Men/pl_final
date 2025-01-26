package vm;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import parser.Parser;
import parser.Scanner;
import parser.ast.Cell;
import vm.pobject.PInteger;
import vm.pobject.PSet;
import vm.pobject.PValue;

public class EvaluatorTest
{

  @ParameterizedTest
  @MethodSource("testCaseProvider")
  void testEvaluator(List<Cell> statement, SymbolTable environment, String expectedOutput, String expectedEnvironment)
  {
    for (Cell cell : statement)
    {
      var evaluator = new Evaluator(cell, environment);
      evaluator.perform();
    }

    assertEquals(expectedEnvironment.strip(), environment.toString().strip());
  }

  private static Stream<Arguments> testCaseProvider()
  {
    return Stream.of(
        testCase01(),
        testCase02(),
        testCase03(),
        testCase05());
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
    List<Cell> statement = new Parser(new Scanner(inputString)).parse();
    SymbolTable environment = new SymbolTable();
    String expectedOutput = "";
    String expectedEnvironment = """
        A_set: {-3, 4, 11}
        N: <builtin set (natural)>
        R: <builtin set (real)>
        """;
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

  /**
   * ドメイン限定子のテスト(自然数)
   * 
   * @return
   */
  private static Arguments testCase02()
  {
    String inputString = """
        (ASSERT (UPPER_ID A_set)
          (EXPRESSION
            (DOMLIMMITEDSET (UPPER_ID N)
              (DOMAINLIMITER
                (RANGE (INTEGER 1) (INTEGER 10)) (INTEGER 2)))))
                """;
    List<Cell> statement = new Parser(new Scanner(inputString)).parse();
    SymbolTable environment = new SymbolTable();
    String expectedOutput = "";
    String expectedEnvironment = """
        A_set: {1, 3, 5, 7, 9}
        N: <builtin set (natural)>
        R: <builtin set (real)>
        """;
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

  /**
   * ドメイン限定子のテスト(実数)
   * 
   * @return
   */
  private static Arguments testCase03()
  {
    String inputString = """
        (ASSERT (UPPER_ID A_set)
          (EXPRESSION
            (DOMLIMMITEDSET (UPPER_ID R)
              (DOMAINLIMITER
                (RANGE (REAL 0.0) (REAL 1.0)) (REAL 0.2)))))
                """;
    List<Cell> statement = new Parser(new Scanner(inputString)).parse();
    SymbolTable environment = new SymbolTable();
    String expectedOutput = "";
    String expectedEnvironment = """
        A_set: {0.000, 0.200, 0.400, 0.600, 0.800, 1.000}
        N: <builtin set (natural)>
        R: <builtin set (real)>
        """;
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

  /**
   * 内包表記のテスト
   * 
   * @return
   */
  private static Arguments testCase04()
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
    List<Cell> statement = new Parser(new Scanner(inputString)).parse();
    SymbolTable environment = new SymbolTable();
    PSet sampleSet = PSet.fromIterator(
        IntStream.iterate(0, i -> i + 2).takeWhile(i -> i < 10).mapToObj(i -> (PValue) new PInteger(i)).iterator());

    environment.put("X", sampleSet);

    String expectedOutput = "";
    String expectedEnvironment = """
        A_set: {}
        N: <builtin set (natural)>
        R: <builtin set (real)>
        """;
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

  /**
   * 集合演算のテスト
   * 
   * @return
   */
  private static Arguments testCase05()
  {
    String inputString = """
        (ASSERT (UPPER_ID A)
          (EXTENSION
              (SETELEMENTS
                  (SETELEMENT (INTEGER 1))
                  (SETELEMENT (INTEGER 2))
                  (SETELEMENT (INTEGER 3)))))

        (ASSERT (UPPER_ID B)
          (EXTENSION
              (SETELEMENTS
                  (SETELEMENT (INTEGER 2))
                  (SETELEMENT (INTEGER 3))
                  (SETELEMENT (INTEGER 4)))))

        (ASSERT (UPPER_ID C)
          (EXPRESSION
            (+ (UPPER_ID A) (UPPER_ID B))))

        (ASSERT (UPPER_ID D)
          (EXPRESSION
            (- (UPPER_ID A) (UPPER_ID B))))

        (ASSERT (UPPER_ID E)
          (EXPRESSION
            (* (UPPER_ID A) (UPPER_ID B))))

        (ASSERT (UPPER_ID F)
          (EXPRESSION
            (^ (UPPER_ID A) (UPPER_ID B))))
                        """;
    List<Cell> statement = new Parser(new Scanner(inputString)).parse();
    SymbolTable environment = new SymbolTable();
    String expectedOutput = "";
    String expectedEnvironment = """
        A: {1, 2, 3}
        B: {2, 3, 4}
        C: {1, 2, 3, 4}
        D: {1}
        E: {2, 3}
        F: {1, 4}
        N: <builtin set (natural)>
        R: <builtin set (real)>
        """;
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

}

package vm;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
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

  @Test
  void testError()
  {
    String inputString = """
        (YYERROR "syntax error at 1: nearby .")
        """;
    Parser parser = new Parser(inputString);
    List<Cell> statements = parser.parse();
    SymbolTable symbolTable = new SymbolTable();

    StringBuffer output = new StringBuffer();
    for (Cell cell : statements)
    {
      var evaluator = new Evaluator(cell, symbolTable);
      evaluator.perform();

      output.append(evaluator.output());
    }

    assertEquals("\"syntax error at 1: nearby .\"", output.toString().strip());
  }

  @Test
  void testSpecial01()
  {
    String inputString = """
        (ASSERT (UPPER_ID A)
            (INTENSION
                (SETELEMENT (LOWER_ID x))
                (AND
                    (=
                        (-
                            (*
                                (* (LOWER_ID x) (LOWER_ID x)) (LOWER_ID x))
                            (* (INTEGER 9) (LOWER_ID x))) (INTEGER 0))
                    (~
                        (SETELEMENT (LOWER_ID x))
                        (EXPRESSION
                            (DOMLIMMITEDSET (UPPER_ID N)
                                (DOMAINLIMITER
                                    (RANGE (INTEGER -10) (INTEGER 10)) (INTEGER 1))))))))

        (ASSERT (UPPER_ID A)
            (INTENSION
                (SETELEMENT (LOWER_ID x))
                (AND
                    (= (LOWER_ID x)
                        (+
                            (* (INTEGER 2) (LOWER_ID y)) (INTEGER 1)))
                    (~
                        (SETELEMENT (LOWER_ID y))
                        (EXPRESSION (UPPER_ID A))))))

        (PROVE
            (AND
                (=
                    (+
                        (* (LOWER_ID x) (LOWER_ID x)) (INTEGER 1)) (INTEGER 2))
                (~
                    (SETELEMENT (LOWER_ID x))
                    (EXPRESSION (UPPER_ID A)))))
                    """;
    Parser parser = new Parser(inputString);
    List<Cell> statements = parser.parse();
    SymbolTable symbolTable = new SymbolTable();

    StringBuffer output = new StringBuffer();
    for (Cell cell : statements)
    {
      var evaluator = new Evaluator(cell, symbolTable);
      evaluator.perform();

      output.append(evaluator.output());
    }

    String expectedOutput = """
        {-3, 0, 3}
        {-5, 1, 7}
        no.
        """;
    assertEquals(expectedOutput.strip(), output.toString().strip());
  }

  @ParameterizedTest
  @MethodSource("testCaseProvider")
  void testEvaluator(List<Cell> statement, SymbolTable environment, String expectedOutput, String expectedEnvironment)
  {
    StringBuffer output = new StringBuffer();
    for (Cell cell : statement)
    {
      var evaluator = new Evaluator(cell, environment);
      evaluator.perform();

      output.append(evaluator.output());
    }

    assertEquals(expectedOutput.strip(), output.toString().strip());
    assertEquals(expectedEnvironment.strip(), environment.toString().strip());
  }

  private static Stream<Arguments> testCaseProvider()
  {
    return Stream.of(
        testCase00(),
        testCase01(),
        testCase02(),
        testCase03(),
        testCase04(),
        testCase05(),
        testCase06(),
        testCase07(),
        testCase08(),
        testCase09(),
        testCase10(),
        testCase11(),
        testCase12(),
        testCase13(),
        testCase14(),
        testCase15());
  }

  /**
   * 空集合のテスト
   * 
   * @return
   */
  private static Arguments testCase00()
  {
    String inpuString = """
        (ASSERT (UPPER_ID A)
          (EXTENSION ()))
        """;
    List<Cell> program = new Parser(new Scanner(inpuString)).parse();
    SymbolTable environment = new SymbolTable();
    String expectedOutput = "{}";
    String expectedEnvironment = """
        A: {}
        N: <builtin set (natural)>
        R: <builtin set (real)>
        """;
    return arguments(program, environment, expectedOutput, expectedEnvironment);
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
    String expectedOutput = "{-3, 4, 11}";
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
    String expectedOutput = "{1, 3, 5, 7, 9}";
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
    String expectedOutput = "{0.000, 0.200, 0.400, 0.600, 0.800, 1.000}";
    String expectedEnvironment = """
        A_set: {0.000, 0.200, 0.400, 0.600, 0.800, 1.000}
        N: <builtin set (natural)>
        R: <builtin set (real)>
        """;
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

  /**
   * 内包表記のテスト(二つの帰属関係式)
   * 
   * @return
   */
  private static Arguments testCase04()
  {
    String inputString = """
        (ASSERT (UPPER_ID C)
        (INTENSION
            (SETELEMENT (LOWER_ID y))
            (AND
                (~
                    (SETELEMENT (LOWER_ID y))
                    (EXPRESSION (UPPER_ID A)))
                (~
                    (SETELEMENT (LOWER_ID y))
                    (EXPRESSION (UPPER_ID B))))))
            """;
    List<Cell> statement = new Parser(new Scanner(inputString)).parse();
    SymbolTable environment = new SymbolTable();
    PSet setA = PSet.fromIterator(IntStream.of(1, 3, 5, 7).mapToObj(i -> (PValue) new PInteger(i)).iterator());
    PSet setB = PSet.fromIterator(IntStream.of(2, 3, 4, 5).mapToObj(i -> (PValue) new PInteger(i)).iterator());
    environment.put("A", setA);
    environment.put("B", setB);

    String expectedOutput = "{3, 5}";
    String expectedEnvironment = """
        A: {1, 3, 5, 7}
        B: {2, 3, 4, 5}
        C: {3, 5}
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
    String expectedOutput = """
        {1, 2, 3}
        {2, 3, 4}
        {1, 2, 3, 4}
        {1}
        {2, 3}
        {1, 4}
        """;
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

  /**
   * 内包表記のテスト（一つの帰属関係式）
   * 
   * @return
   */
  private static Arguments testCase06()
  {
    String inputString = """
        (ASSERT (UPPER_ID B)
            (INTENSION
                (SETELEMENT (LOWER_ID x))
                (AND
                    (= (LOWER_ID x)
                        (+
                            (* (INTEGER 2) (LOWER_ID y)) (INTEGER 1)))
                    (~
                        (SETELEMENT (LOWER_ID y))
                        (EXPRESSION (UPPER_ID A))))))
            """;
    List<Cell> statement = new Parser(new Scanner(inputString)).parse();
    SymbolTable environment = new SymbolTable();
    PSet setA = PSet.fromIterator(IntStream.of(0, 1, 2, 3, 4).mapToObj(i -> (PValue) new PInteger(i)).iterator());
    environment.put("A", setA);

    String expectedOutput = "{1, 3, 5, 7, 9}";
    String expectedEnvironment = """
        A: {0, 1, 2, 3, 4}
        B: {1, 3, 5, 7, 9}
        N: <builtin set (natural)>
        R: <builtin set (real)>
        """;
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

  /**
   * 内包表記のテスト（入れ子になった帰属関係式）
   * 
   * @return
   */
  private static Arguments testCase07()
  {
    String inputString = """
        (ASSERT (UPPER_ID C)
            (INTENSION
                (SETELEMENT (LOWER_ID x))
                (AND
                    (AND
                        (AND
                            (= (LOWER_ID x)
                                (+
                                    (* (INTEGER 2) (LOWER_ID y))
                                    (* (INTEGER 3) (LOWER_ID z))))
                            (= (LOWER_ID x)
                                (+
                                    (* (INTEGER 3) (LOWER_ID y))
                                    (* (INTEGER 4) (LOWER_ID z)))))
                        (~
                            (SETELEMENT (LOWER_ID y))
                            (EXPRESSION (UPPER_ID A))))
                    (~
                        (SETELEMENT (LOWER_ID z))
                        (EXPRESSION (UPPER_ID B))))))
                """;
    List<Cell> statement = new Parser(new Scanner(inputString)).parse();
    SymbolTable environment = new SymbolTable();
    PSet setA = PSet.fromIterator(IntStream.of(1, 3, 5, 7).mapToObj(i -> (PValue) new PInteger(i)).iterator());
    PSet setB = PSet.fromIterator(IntStream.of(2, 3, 4, 5).mapToObj(i -> (PValue) new PInteger(i)).iterator());
    environment.put("A", setA);
    environment.put("B", setB);

    String expectedOutput = "{11, 15, 17, 19, 21, 23, 25, 29}";
    String expectedEnvironment = """
        A: {1, 3, 5, 7}
        B: {2, 3, 4, 5}
        C: {11, 15, 17, 19, 21, 23, 25, 29}
        N: <builtin set (natural)>
        R: <builtin set (real)>
        """;
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

  /**
   * 文字列からなる集合のテスト
   * 
   * @return
   */
  private static Arguments testCase08()
  {
    String inputString = """
        (ASSERT (UPPER_ID A)
            (EXTENSION
                (SETELEMENTS
                    (SETELEMENT (STRING "wine"))
                    (SETELEMENT (STRING "mary")))))
            """;
    List<Cell> statement = new Parser(new Scanner(inputString)).parse();
    SymbolTable environment = new SymbolTable();
    String expectedOutput = "{\"mary\", \"wine\"}";
    String expectedEnvironment = """
        A: {"mary", "wine"}
        N: <builtin set (natural)>
        R: <builtin set (real)>
        """;
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

  /**
   * 整数の集合に対する単純な質問のテスト（ふくまれる要素）
   * 
   * @return
   */
  private static Arguments testCase09()
  {
    String inputString = """
        (PROVE
                (~
                    (SETELEMENT (INTEGER 3))
                    (EXPRESSION
                        (DOMLIMMITEDSET (UPPER_ID N)
                            (DOMAINLIMITER
                                (RANGE (INTEGER 1) (INTEGER 10)) (INTEGER 1))))))
                """;
    List<Cell> statement = new Parser(new Scanner(inputString)).parse();
    SymbolTable environment = new SymbolTable();
    String expectedOutput = "yes.";
    String expectedEnvironment = """
        N: <builtin set (natural)>
        R: <builtin set (real)>
        """;
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

  /**
   * 整数の集合に対する単純な質問のテスト（ふくまれない要素）
   * 
   * @return
   */
  private static Arguments testCase10()
  {
    String inputString = """
        (PROVE
                (~
                    (SETELEMENT (INTEGER -1))
                    (EXPRESSION
                        (DOMLIMMITEDSET (UPPER_ID N)
                            (DOMAINLIMITER
                                (RANGE (INTEGER 1) (INTEGER 10)) (INTEGER 1))))))
                """;
    List<Cell> statement = new Parser(new Scanner(inputString)).parse();
    SymbolTable environment = new SymbolTable();
    String expectedOutput = "no.";
    String expectedEnvironment = """
        N: <builtin set (natural)>
        R: <builtin set (real)>
        """;
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

  /**
   * 「AND」を含む質問
   * 
   * @return
   */
  private static Arguments testCase11()
  {
    String inputString = """
        (PROVE
            (AND
                (~
                    (SETELEMENT (INTEGER 3))
                    (EXPRESSION (UPPER_ID A)))
                (~
                    (SETELEMENT (INTEGER 4))
                    (EXPRESSION (UPPER_ID A)))))

        (PROVE
            (AND
                (~
                    (SETELEMENT (INTEGER -1))
                    (EXPRESSION (UPPER_ID A)))
                (~
                    (SETELEMENT (INTEGER 4))
                    (EXPRESSION (UPPER_ID A)))))
            """;
    List<Cell> statement = new Parser(inputString).parse();
    SymbolTable environment = new SymbolTable();
    PSet setA = PSet.fromIterator(IntStream.of(1, 2, 3, 4).mapToObj(i -> (PValue) new PInteger(i)).iterator());
    environment.put("A", setA);
    String expectedOutput = """
        yes.
        no.
        """;
    String expectedEnvironment = """
        A: {1, 2, 3, 4}
        N: <builtin set (natural)>
        R: <builtin set (real)>
        """;
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

  /**
   * 「OR」をふくむ質問
   * 
   * @return
   */
  private static Arguments testCase12()
  {
    String inputString = """
        (PROVE
            (OR
                (~
                    (SETELEMENT (INTEGER 10))
                    (EXPRESSION (UPPER_ID A)))
                (~
                    (SETELEMENT (INTEGER 15))
                    (EXPRESSION (UPPER_ID A)))))

        (PROVE
            (OR
                (~
                    (SETELEMENT (INTEGER -1))
                    (EXPRESSION (UPPER_ID A)))
                (~
                    (SETELEMENT (INTEGER 4))
                    (EXPRESSION (UPPER_ID A)))))
            """;
    List<Cell> statement = new Parser(inputString).parse();
    SymbolTable environment = new SymbolTable();
    PSet setA = PSet.fromIterator(IntStream.of(1, 2, 3, 4).mapToObj(i -> (PValue) new PInteger(i)).iterator());
    environment.put("A", setA);
    String expectedOutput = """
        no.
        yes.
        """;
    String expectedEnvironment = """
        A: {1, 2, 3, 4}
        N: <builtin set (natural)>
        R: <builtin set (real)>
        """;
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

  /**
   * 充足試行のテスト
   * 
   * @return
   */
  private static Arguments testCase13()
  {
    String inputString = """
        (PROVE
            (~
                (SETELEMENT (LOWER_ID x))
                (EXPRESSION
                    (DOMLIMMITEDSET (UPPER_ID N)
                        (DOMAINLIMITER
                            (RANGE (INTEGER 1) (INTEGER 5)) (INTEGER 1))))))
            """;
    List<Cell> statement = new Parser(inputString).parse();
    SymbolTable environment = new SymbolTable();
    String expectedOutput = """
        {1, 2, 3, 4, 5}
        """;
    String expectedEnvironment = """
        N: <builtin set (natural)>
        R: <builtin set (real)>
        """;
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

  private static Arguments testCase14()
  {
    String inputString = """
        (ASSERT (UPPER_ID TomLikes)
            (EXTENSION
                (SETELEMENTS
                    (SETELEMENT (STRING "mary"))
                    (SETELEMENT (STRING "wine"))
                    (SETELEMENT (STRING "apple")))))

        (ASSERT (UPPER_ID KenLikes)
            (EXTENSION
                (SETELEMENTS
                    (SETELEMENT (STRING "mary"))
                    (SETELEMENT (STRING "coffee"))
                    (SETELEMENT (STRING "apple")))))

        (PROVE
            (AND
                (!~
                    (SETELEMENT (LOWER_ID x))
                    (EXPRESSION (UPPER_ID KenLikes)))
                (~
                    (SETELEMENT (LOWER_ID x))
                    (EXPRESSION (UPPER_ID TomLikes)))))
                """;

    List<Cell> statement = new Parser(inputString).parse();
    SymbolTable environment = new SymbolTable();
    String expectedOutput = """
        {"apple", "mary", "wine"}
        {"apple", "coffee", "mary"}
        {"wine"}
        """;
    String expectedEnvironment = """
        KenLikes: {"apple", "coffee", "mary"}
        N: <builtin set (natural)>
        R: <builtin set (real)>
        TomLikes: {"apple", "mary", "wine"}
        """;
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }

  /**
   * 方程式をふくむ集合定義
   * 
   * @return
   */
  private static Arguments testCase15()
  {
    String inputString = """
        (ASSERT (UPPER_ID A)
            (INTENSION
                (SETELEMENT (LOWER_ID x))
                (AND
                    (=
                        (-
                            (* (LOWER_ID x) (LOWER_ID x))
                            (* (INTEGER 2) (LOWER_ID x))) (INTEGER 0))
                    (~
                        (SETELEMENT (LOWER_ID x))
                        (EXTENSION
                            (SETELEMENTS
                                (SETELEMENT (INTEGER -3))
                                (SETELEMENT (INTEGER -2))
                                (SETELEMENT (INTEGER -1))
                                (SETELEMENT (INTEGER 0))
                                (SETELEMENT (INTEGER 1))
                                (SETELEMENT (INTEGER 2))
                                (SETELEMENT (INTEGER 3))))))))
                    """;
    List<Cell> statement = new Parser(inputString).parse();
    SymbolTable environment = new SymbolTable();
    String expectedOutput = """
        {0, 2}
        """;
    String expectedEnvironment = """
        A: {0, 2}
        N: <builtin set (natural)>
        R: <builtin set (real)>
        """;
    return arguments(statement, environment, expectedOutput, expectedEnvironment);
  }
}

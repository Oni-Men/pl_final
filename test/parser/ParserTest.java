package parser;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import parser.ast.Token;

import static parser.ast.TokenType.*;

public class ParserTest
{
  static class ListEnumerateScanner implements IScanner
  {
    private Iterator<Token> tokenIterator;

    public ListEnumerateScanner(Iterable<Token> tokenIterable)
    {
      this.tokenIterator = tokenIterable.iterator();
    }

    public Token next()
    {
      if (!tokenIterator.hasNext())
      {
        return null;
      }
      return this.tokenIterator.next();
    }
  }

  @ParameterizedTest
  @MethodSource("testCaseProvider")
  void testParser(List<Token> tokenSequence, String expectedString)
  {
    var scanner = new ListEnumerateScanner(tokenSequence);
    var parser = new Parser(scanner);

    var program = parser.parse();
    var resultString = String.join("\n",
        program.stream().map(node -> node.printString()).toList());

    // 1個以上の空白や改行などの意味を持たない文字を取り除く
    expectedString = expectedString.replaceAll("[\n\s]+", " ").strip();
    resultString = resultString.replaceAll("[\n\s]+", " ").strip();

    assertEquals(expectedString, resultString);
  }

  @ParameterizedTest
  @MethodSource("testCaseProvider2")
  void testParserWithScanner(String inputString)
  {
    IScanner aScanner = new Scanner(inputString);
    IParser aParser = new Parser(aScanner);

    var program = aParser.parse();
    var resultString = String.join("\n",
        program.stream().map(node -> node.printString()).toList());

    // 1個以上の空白や改行などの意味を持たない文字を取り除く
    String expectedString = inputString.replaceAll("[\n\s]+", " ").strip();
    resultString = resultString.replaceAll("[\n\s]+", " ").strip();

    // ()をnilに置き換える
    expectedString = expectedString.replaceAll("\\(\\)", "nil");

    assertEquals(expectedString, resultString);
  }

  static Stream<Arguments> testCaseProvider()
  {
    return Stream.of(
        testCase01(),
        testCase02(),
        testCase03());
  }

  static Arguments testCase01()
  {
    var expected = """
        (= x 3)""";

    return arguments(Arrays.asList(
        new Token(LPAR, "("),
        new Token(EQUAL, "="),
        new Token(ID, "x"),
        new Token(NUMBER, "3"),
        new Token(RPAR, ")")), expected);
  }

  static Arguments testCase02()
  {
    var expected = """
        (ASSERT
          (PARAMS
            (UPPER_ID A)
            (UPPER_ID N))
          (INTENSION
            (LOWER_ID x)
            (AND
              (OR
                (= x (* 5 y))
                (= x (* 6 y)))
              (IN y N))))""";
    return arguments(
        Arrays.asList(
            new Token(LPAR, "("),
            new Token(ID, "ASSERT"),
            new Token(LPAR, "("),
            new Token(ID, "PARAMS"),
            new Token(LPAR, "("),
            new Token(ID, "UPPER_ID"),
            new Token(ID, "A"),
            new Token(RPAR, ")"),
            new Token(LPAR, "("),
            new Token(ID, "UPPER_ID"),
            new Token(ID, "N"),
            new Token(RPAR, ")"),
            new Token(RPAR, ")"),
            new Token(LPAR, "("),
            new Token(ID, "INTENSION"),
            new Token(LPAR, "("),
            new Token(ID, "LOWER_ID"),
            new Token(ID, "x"),
            new Token(RPAR, ")"),
            new Token(LPAR, "("),
            new Token(ID, "AND"),
            new Token(LPAR, "("),
            new Token(ID, "OR"),
            new Token(LPAR, "("),
            new Token(EQUAL, "="),
            new Token(ID, "x"),
            new Token(LPAR, "("),
            new Token(MULTIPLY, "*"),
            new Token(NUMBER, "5"),
            new Token(ID, "y"),
            new Token(RPAR, ")"),
            new Token(RPAR, ")"),
            new Token(LPAR, "("),
            new Token(EQUAL, "="),
            new Token(ID, "x"),
            new Token(LPAR, "("),
            new Token(MULTIPLY, "*"),
            new Token(NUMBER, "6"),
            new Token(ID, "y"),
            new Token(RPAR, ")"),
            new Token(RPAR, ")"),
            new Token(RPAR, ")"),
            new Token(LPAR, "("),
            new Token(ID, "IN"),
            new Token(ID, "y"),
            new Token(ID, "N"),
            new Token(RPAR, ")"),
            new Token(RPAR, ")"),
            new Token(RPAR, ")"),
            new Token(RPAR, ")")),
        expected);
  }

  static Arguments testCase03()
  {
    var expected = """
        (x)
        """;

    return arguments(Arrays.asList(
        new Token(LPAR, "("),
        new Token(ID, "x"),
        new Token(RPAR, ")")), expected);
  }

  static Stream<Arguments> testCaseProvider2()
  {
    return Stream.of(
        arguments("()"),
        arguments("(())"),
        arguments("(1 2 3)"),
        arguments("(1 2 3 (4 (5) 6) 7 8 9)"),
        arguments("((1 2 3) 4 5)"),
        arguments("(1 2 3 (4 5))"),
        arguments("(1 2 ())"),
        arguments("(java python smalltalk lisp)"),
        arguments("((oop java python) (functional lisp haskell) (logic prolog))"),
        arguments("""
            (PROVE
                (~
                    (SETELEMENT
                        (TupleElement (LOWER_ID aaa) (INTEGER 0)))
                    (EXPRESSION (UPPER_ID A_set))))
                    """),
        arguments("""
            (ASSERT (UPPER_ID A_set)
              (EXPRESSION
                (DOMLIMMITEDSET (UPPER_ID R)
                  (DOMAINLIMITER
                    (RANGE (INTEGER 0.0) (INTEGER 1.0)) (INTEGER 0.2)))))
                """));
  }
}

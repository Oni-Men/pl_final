package parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import parser.ast.Token;
import parser.ast.TokenType;
import static parser.ast.TokenType.*;

public class ScannerTest
{
  @ParameterizedTest
  @MethodSource("testCaseProvider")
  void testScanner(String sourceString, List<TokenType> tokenTypeSequence)
  {
    Scanner aScanner = new Scanner(sourceString);
    Iterator<TokenType> anIterator = tokenTypeSequence.iterator();

    Token token;
    while (true)
    {
      token = aScanner.next();
      if (token.tokenType() == EOF)
      {
        break;
      }
      assertTrue(anIterator.hasNext());
      assertEquals(anIterator.next(), token.tokenType());
    }
    assertFalse(anIterator.hasNext());
  }

  static Stream<Arguments> testCaseProvider()
  {
    return Stream.of(
        arguments("(+ X Y Z)", Arrays.asList(LPAR, PLUS, ID, ID, ID, RPAR)),
        arguments("0.5 -3.14 3.3333", Arrays.asList(REAL, REAL, REAL)),
        arguments("(YYERROR \"syntax error at 1: nearby .\")", Arrays.asList(LPAR, ID, STRING, RPAR)),
        arguments("""
            (ASSERT
              (A N)
              (x)
              (AND
                (OR
                  (= x (* 5 y))
                  (= x (* 5 y)))
                (IN y N)))
            """,
            Arrays.asList(LPAR, ID,
                LPAR, ID, ID, RPAR,
                LPAR, ID, RPAR,
                LPAR, ID,
                LPAR, ID,
                LPAR, EQUAL, ID, LPAR, MULTIPLY, NUMBER, ID, RPAR, RPAR,
                LPAR, EQUAL, ID, LPAR, MULTIPLY, NUMBER, ID, RPAR, RPAR, RPAR,
                LPAR, ID, ID, ID, RPAR, RPAR, RPAR)));
  }
}

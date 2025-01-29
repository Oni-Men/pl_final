package parser.ast;

import java.util.regex.Pattern;

import util.Bool;

public enum TokenType
{
  ID("[_a-zA-Z][_a-zA-Z0-9]*"),
  REAL("-?[0-9]+\\.[0-9]+"),
  NUMBER("-?[0-9]+"),
  STRING("\"[a-zA-Z0-9_.:;=\\!#$%&\\(\\)/<>\\?-]*\""),
  EQUAL("="),
  NOTEQ("!="),
  LT("<"),
  GT(">"),
  LE(">="),
  GE(">="),
  IN("~"),
  NOTIN("!~"),
  PLUS("\\+"),
  MINUS("-"),
  MULTIPLY("\\*"),
  EXCLUSIVE("\\^"),
  DIVIDE("/"),
  LPAR("\\("),
  RPAR("\\)"),
  COMMA(","),
  DOT("\\."),
  LINE_FEED("\\n|\\r|\\r\\n"),
  WHITESPACE("\\s|\\t"),
  UNKNOWN("."),
  EOF("");

  private final Pattern pattern;

  private TokenType(String pattern)
  {
    this.pattern = Pattern.compile(pattern);
  }

  public Pattern pattern()
  {
    return pattern;
  }

  public Bool is(TokenType tokenType)
  {
    return Bool.of(this == tokenType);
  }
}

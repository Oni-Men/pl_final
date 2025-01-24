package parser.ast;

import java.util.regex.Pattern;

public enum TokenType
{
  ID("[_a-zA-Z][_a-zA-Z0-9]*"),
  NUMBER("[0-9]+"),
  REAL("[0-9]+\\.[0-9]+"),
  EQUAL("="),
  LT("<"),
  GT(">"),
  LE(">="),
  GE(">="),
  PLUS("\\+"),
  MINUS("-"),
  MULTIPLY("\\*"),
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
}

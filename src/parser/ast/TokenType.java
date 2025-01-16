package parser.ast;

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
  __("\\n|\\r|\\r\\n|\\s|\\t"),
  UNKNOWN(".");

  private final String pattern;

  private TokenType(String pattern)
  {
    this.pattern = pattern;
  }

  public String pattern()
  {
    return pattern;
  }
}

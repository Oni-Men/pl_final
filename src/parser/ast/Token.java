package parser.ast;

public class Token
{
  private TokenType tokenType;
  private String text;

  private Integer columnCount;
  private Integer lineNumber;

  public Token(TokenType tokenType, String text)
  {
    this.tokenType = tokenType;
    this.text = text;
  }

  public TokenType tokenType()
  {
    return this.tokenType;
  }

  public String text()
  {
    return this.text;
  }

  public void columnCount(Integer columnCount)
  {
    this.columnCount = columnCount;
  }

  public Integer columnCount()
  {
    return this.columnCount;
  }

  public void lineNumber(Integer lineNumber)
  {
    this.lineNumber = lineNumber;
  }

  public Integer lineNumber()
  {
    return this.lineNumber;
  }

  @Override
  public String toString()
  {
    return String.format("%s(%s)", this.tokenType().name(), this.text());
  }
}

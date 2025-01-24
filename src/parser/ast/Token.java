package parser.ast;

public class Token
{
  private TokenType tokenType;
  private String text;

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

  @Override
  public String toString()
  {
    return String.format("%s(%s)", this.tokenType().name(), this.text());
  }
}

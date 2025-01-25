package parser.ast;

public class Leaf extends Cell
{

  private Token token;

  public Leaf(Token token)
  {
    super();
    this.token = token;
  }

  public Token token()
  {
    return this.token;
  }

  @Override
  public boolean nil()
  {
    return false;
  }

  public String text()
  {
    return this.token.text();
  }

  @Override
  public void printString(StringBuffer sb, int level)
  {
    sb.append(this.token.text());
  }

}

package parser.ast;

public class Leaf extends Cell
{

  private Token token;

  public Leaf(Token token)
  {
    this.token = token;
  }

  public Token token()
  {
    return this.token;
  }

  @Override
  public void printString(StringBuffer sb, int level)
  {
    sb.append(this.token.text());
  }

}

package parser.ast;

public abstract class Cell
{
  public String printString()
  {
    StringBuffer buffer = new StringBuffer();
    this.printString(buffer, 0);

    return buffer.toString();
  }

  public abstract void printString(StringBuffer sb, int level);
}

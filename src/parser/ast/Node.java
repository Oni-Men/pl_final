package parser.ast;

public class Node extends Cell
{
  private Cell carPart;

  private Cell cdrPart;

  public Node()
  {
  }

  public void head(Cell head)
  {
    this.carPart = head;
  }

  public Cell head()
  {
    return this.carPart;
  }

  public void tail(Cell tail)
  {
    this.cdrPart = tail;
  }

  public Cell tail()
  {
    return this.cdrPart;
  }

  public boolean nil()
  {
    return this.carPart == null;
  }

  public boolean isList()
  {
    return this.cdrPart != null && this.cdrPart instanceof Node;
  }

  public void printString(StringBuffer sb, int level)
  {
    if (this.nil())
    {
      sb.append("nil");
    }
    else
    {
      sb.append("(");
      if (this.carPart instanceof Node carNode)
      {
        carNode.printString(sb, level + 1);
      }
      else
      {
        sb.append(this.carPart.printString());
      }

      if (this.cdrPart instanceof Node cdrNode)
      {
        if (!cdrNode.nil())
        {
          sb.append(" ");
          cdrNode.printTail(sb, level + 1);
        }
      }
      else if (this.cdrPart != null)
      {
        sb.append(" . ");
        this.printString(sb, level + 1);
      }

      sb.append(")");

    }

  }

  private void printTail(StringBuffer sb, int level)
  {
    sb.append(this.carPart.printString());
    if (this.cdrPart != null)
    {
      if (this.cdrPart instanceof Node cdrNode)
      {
        if (!cdrNode.nil())
        {
          sb.append(" ");
          cdrNode.printTail(sb, level);
        }
      }
      else
      {
        this.cdrPart.printString(sb, level);
      }
    }
  }
}

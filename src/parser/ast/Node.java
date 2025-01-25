package parser.ast;

public class Node extends Cell
{

  public Node()
  {
    super();
  }

  public Node(Cell head, Cell tail)
  {
    super(head, tail);
  }

  public void printString(StringBuffer sb, int level)
  {
    if (this.nil())
    {
      super.printString(sb, level);
      return;
    }

    sb.append("(");
    this.head().printString(sb, level + 1);
    if (!this.tail().nil())
    {
      sb.append(" ");
      if (this.tail() instanceof Node cdrNode)
      {
        cdrNode.printTail(sb, level);
      }
      else
      {
        this.tail().printString(sb, level + 1);
      }
    }
    sb.append(")");
  }

  public void printTail(StringBuffer sb, int level)
  {
    if (this.nil())
    {
      return;
    }
    sb.append(this.carPart.printString());
    if (!this.cdrPart.nil())
    {
      sb.append(" ");
      if (this.tail() instanceof Node cdrNode)
      {
        cdrNode.printTail(sb, level);
      }
      else
      {
        this.tail().printString(sb, level);
      }
    }
  }

}

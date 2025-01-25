package parser.ast;

import java.util.function.Function;
import java.util.function.Supplier;

import util.Bool;

public class Cell
{
  protected static final Cell nil = new Cell();

  protected Cell carPart;
  protected Cell cdrPart;

  public Cell()
  {
    this.carPart = Cell.nil;
    this.cdrPart = Cell.nil;
  }

  public Cell(Cell head, Cell tail)
  {
    this.carPart = head;
    this.cdrPart = tail;
  }

  public String printString()
  {
    StringBuffer buffer = new StringBuffer();
    this.printString(buffer, 0);

    return buffer.toString();
  }

  public Cell head()
  {
    return carPart;
  }

  public void head(Cell head)
  {
    if (head == null)
      head = nil;
    this.carPart = head;
  }

  public Cell tail()
  {
    return cdrPart;
  }

  public void tail(Cell tail)
  {
    if (tail == null)
      tail = nil;
    this.cdrPart = tail;
  }

  public boolean nil()
  {
    return this == nil || (head() == nil && tail() == nil);
  }

  public String text()
  {
    return "";
  }

  public <T> T textEquals(String other, Supplier<T> ifTrue)
  {
    return textEquals(other, ifTrue, false);
  }

  public <T> T textEquals(String other, Supplier<T> ifTrue, boolean ignoreCase)
  {
    Function<String, Bool> caseInsensitive = (s) -> Bool.of(this.text().equalsIgnoreCase(s));
    Function<String, Bool> caseSensitive = (s) -> Bool.of(this.text().equals(s));

    if (ignoreCase)
    {
      return caseInsensitive.apply(other).ifTrue(ifTrue);
    }
    else
    {
      return caseSensitive.apply(other).ifTrue(ifTrue);
    }
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
      this.head().printString(sb, level);
      sb.append(" ");
      this.tail().printString(sb, level + 1);
      sb.append(")");
    }
  }
}

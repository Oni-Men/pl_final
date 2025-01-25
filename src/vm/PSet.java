package vm;

import java.util.HashSet;
import java.util.Set;

import parser.ast.Cell;
import util.Bool;

public class PSet extends PObject
{
  private Set<PValue> elements;

  public static PSet fromExtension(Cell cell)
  {
    PSet pSet = new PSet();
    Cell element = cell.head().head().textEquals("setelements", () -> {
      return cell.head().tail();
    }, true);

    while (!element.nil())
    {
      PValue value = PValue.fromSetElement(element.head());

      pSet.elements.add(value);
      element = element.tail();
    }

    return pSet;
  }

  public static PSet fromIntension(Cell cell)
  {
    return null;
  }

  public PSet()
  {
    this.elements = new HashSet<>();
  }

  public Bool include(PValue value)
  {
    return Bool.of(this.elements.contains(value));
  }

  /**
   * 和集合を求める
   * 
   * @param anotherSet
   * @return
   */
  public PSet union(PSet anotherSet)
  {
    return null;
  }

  /**
   * 差集合を求める
   * 
   * @param anotherSet
   * @return
   */
  public PSet difference(PSet anotherSet)
  {
    return null;
  }

  /**
   * 積集合を求める
   * 
   * @param anotherSet
   * @return
   */
  public PSet intersect(PSet anotherSet)
  {
    return null;
  }

  /**
   * 排他的和集合を求める
   * 
   * @param anoterSet
   * @return
   */
  public PSet exclusive(PSet anoterSet)
  {
    return null;
  }

  @Override
  public String toString()
  {
    StringBuffer aBuffer = new StringBuffer();

    aBuffer.append("{");
    aBuffer.append(String.join(",", this.elements.stream().map(pObject -> pObject.toString()).toList()));
    aBuffer.append("}");

    return aBuffer.toString();
  }
}

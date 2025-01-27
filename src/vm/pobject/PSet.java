package vm.pobject;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import parser.ast.Cell;
import util.Bool;
import vm.SymbolTable;
import vm.condition.Conditions;

public class PSet extends PObject
{
  private Set<PValue> elements;

  public static PSet fromExtension(Cell cell)
  {
    PSet pSet = new PSet();
    if (cell.head().nil())
    {
      return pSet;
    }
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

  public static PSet fromIterator(Iterator<PValue> valueIterator)
  {
    PSet pSet = new PSet();
    while (valueIterator.hasNext())
    {
      pSet.elements.add(valueIterator.next());
    }

    return pSet;
  }

  public static PSet fromIntension(Cell cell, SymbolTable symbolTable)
  {
    PSet pSet = new PSet();

    Cell setElement = cell.head().head().textEquals("setelement", () -> cell.head().next());
    Bool.of(setElement.nil()).throwIfTrue(() -> new RuntimeException("Invalid format: SetElement"));

    Cell conditions = cell.tail();
    Bool.of(conditions.nil()).throwIfTrue(() -> new RuntimeException("Invalid format: Conditions"));

    return Conditions.of(setElement, conditions, symbolTable);
  }

  public PSet()
  {
    this.elements = new HashSet<>();
  }

  public PSet(PValue... values)
  {
    this.elements = new HashSet<>();
    for (PValue pValue : values)
    {
      this.elements.add(pValue);
    }
  }

  public Iterable<PValue> values()
  {
    return this.elements;
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
    PSet result = new PSet();
    for (PValue element : this.elements)
    {
      result.elements.add(element);
    }
    for (PValue element : anotherSet.elements)
    {
      result.elements.add(element);
    }

    return result;
  }

  /**
   * 差集合を求める
   * 
   * @param anotherSet
   * @return
   */
  public PSet difference(PSet anotherSet)
  {
    PSet result = new PSet();
    for (PValue element : this.elements)
    {
      anotherSet.include(element)
          .ifFalse(() -> result.elements.add(element));
    }

    return result;
  }

  /**
   * 積集合を求める
   * 
   * @param anotherSet
   * @return
   */
  public PSet intersect(PSet anotherSet)
  {
    PSet result = new PSet();
    for (PValue element : this.elements)
    {
      anotherSet.include(element)
          .ifTrue(() -> result.elements.add(element));
    }
    return result;
  }

  /**
   * 排他的和集合を求める
   * 
   * @param anoterSet
   * @return
   */
  public PSet exclusive(PSet anotherSet)
  {
    PSet result = new PSet();
    for (PValue element : this.elements)
    {
      anotherSet.include(element)
          .ifFalse(() -> result.elements.add(element));
    }

    for (PValue element : anotherSet.elements)
    {
      this.include(element)
          .ifFalse(() -> result.elements.add(element));
    }

    return result;
  }

  /**
   * ドメインを限定する
   * 
   * @return
   */
  public PSet limitDomain(Number lowerBound, Number upperBound)
  {
    Iterator<PValue> valueIterator = this.elements.stream()
        .filter(pValue -> {
          if (pValue instanceof PInteger pInteger)
          {
            return (lowerBound.longValue() <= pInteger.value() && pInteger.value() <= upperBound.longValue());
          }
          return false;
        })
        .iterator();

    return PSet.fromIterator(valueIterator);
  }

  /**
   * ドメインを限定する
   * 
   * @return
   */
  public PSet limitDomain(Number lowerBound, Number upperBound, Number step)
  {
    return limitDomain(lowerBound, upperBound);
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj == null)
    {
      return false;
    }

    if (obj instanceof PSet anotherSet)
    {
      boolean necessary = this.elements.stream().allMatch(pValue -> anotherSet.include(pValue).value());
      boolean sufficient = anotherSet.elements.stream().allMatch(pValue -> this.include(pValue).value());

      return necessary && sufficient;
    }

    return false;
  }

  @Override
  public String toString()
  {
    StringBuffer aBuffer = new StringBuffer();

    aBuffer.append("{");
    aBuffer.append(String.join(", ",
        this.elements.stream().sorted().map(pObject -> pObject.toString()).toList()));
    aBuffer.append("}");

    return aBuffer.toString();
  }
}

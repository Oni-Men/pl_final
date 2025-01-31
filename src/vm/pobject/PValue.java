package vm.pobject;

import parser.ast.Cell;
import util.Cond;

public class PValue extends PObject implements Comparable<PValue>
{
  private static final PValue nil = new PValue();

  public static PValue fromSetElement(Cell cell)
  {
    /*
     * Looks like this if print.
     * 
     * (SETELEMENT (INTEGER -3))
     * 
     * 
     * But actually is like this
     * 
     * (SETELEMENT (INTEGER (-3 nil)))
     */
    PValue result = nil;
    if (cell.head().text().equalsIgnoreCase("setelement"))
    {
      String elementType = cell.next().head().text();
      String valueString = cell.next().next().text();

      result = Cond
          .<String, PValue>when((s) -> s.equalsIgnoreCase("string"),
              () -> new PString(valueString, true))
          .or((s) -> s.equalsIgnoreCase("integer"),
              () -> new PInteger(valueString))
          .or((s) -> s.equalsIgnoreCase("real"),
              () -> new PReal(valueString))
          .or((s) -> s.equalsIgnoreCase("lower_id"),
              () -> new PVariable(valueString))
          .get(elementType, nil);
    }

    return result;
  }

  public boolean nil()
  {
    return this == nil;
  }

  public PValue add(PValue anothValue)
  {
    return this;
  }

  public PValue subtract(PValue anothValue)
  {
    return this;
  }

  public PValue multiply(PValue anothValue)
  {
    return this;
  }

  public PValue divide(PValue anothValue)
  {
    return this;
  }

  @Override
  public int compareTo(PValue o)
  {
    throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
  }

}

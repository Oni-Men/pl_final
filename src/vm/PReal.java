package vm;

public class PReal extends PValue
{
  private double value;

  public PReal(String value)
  {
    this.value = Double.parseDouble(value);
  }

  @Override
  public int hashCode()
  {
    return Double.hashCode(value);
  }
}

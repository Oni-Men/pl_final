package vm;

public class PInteger extends PValue
{
  private long value;

  public PInteger(String value)
  {
    this.value = Long.parseLong(value);
  }

  @Override
  public int hashCode()
  {
    return Long.hashCode(this.value);
  }

  @Override
  public String toString()
  {
    return String.valueOf(this.value);
  }
}

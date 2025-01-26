package vm.pobject;

public class PInteger extends PValue
{
  private long value;

  public PInteger(String value)
  {
    this.value = Long.parseLong(value);
  }

  public PInteger(Long value)
  {
    this.value = value;
  }

  public PInteger(Integer value)
  {
    this.value = value;
  }

  public long value()
  {
    return value;
  }

  @Override
  public int hashCode()
  {
    return Long.hashCode(this.value);
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof PInteger pInt)
    {
      return Long.compare(this.value, pInt.value) == 0;
    }

    return false;
  }

  @Override
  public String toString()
  {
    return String.valueOf(this.value);
  }

  @Override
  public int compareTo(PValue o)
  {
    if (o instanceof PInteger pInteger)
    {
      return (int) (this.value - pInteger.value);
    }

    return 0;
  }
}

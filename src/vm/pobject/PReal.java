package vm.pobject;

public class PReal extends PValue
{
  private double value;

  public PReal(String value)
  {
    this.value = Double.parseDouble(value);
  }

  public PReal(Double value)
  {
    this.value = value;
  }

  @Override
  public int hashCode()
  {
    return Double.hashCode(value);
  }

  @Override
  public String toString()
  {
    return String.format("%.3f", value);
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof PReal pReal)
    {
      return Double.compare(this.value, pReal.value) == 0;
    }

    return false;
  }

  @Override
  public int compareTo(PValue o)
  {
    if (o instanceof PReal pReal)
    {
      return Double.compare(this.value, pReal.value);
    }

    return 0;
  }
}

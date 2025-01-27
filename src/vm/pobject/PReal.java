package vm.pobject;

public class PReal extends PValue
{
  protected double value;

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

  @Override
  public PValue add(PValue anothValue)
  {
    if (anothValue instanceof PInteger anotherInteger)
    {
      return new PReal(this.value + anotherInteger.value);
    }
    if (anothValue instanceof PReal anotherReal)
    {
      return new PReal(this.value + anotherReal.value);
    }
    return super.add(anothValue);
  }

  @Override
  public PValue subtract(PValue anothValue)
  {
    if (anothValue instanceof PInteger anotherInteger)
    {
      return new PReal(this.value - anotherInteger.value);
    }
    if (anothValue instanceof PReal anotherReal)
    {
      return new PReal(this.value - anotherReal.value);
    }
    return super.subtract(anothValue);
  }

  @Override
  public PValue multiply(PValue anothValue)
  {
    if (anothValue instanceof PInteger anotherInteger)
    {
      return new PReal(this.value * anotherInteger.value);
    }
    if (anothValue instanceof PReal anotherReal)
    {
      return new PReal(this.value * anotherReal.value);
    }
    return super.multiply(anothValue);
  }

  @Override
  public PValue divide(PValue anothValue)
  {
    if (anothValue instanceof PInteger anotherInteger)
    {
      if (anotherInteger.value == 0)
      {
        throw new RuntimeException("Invalid operation: zero division");
      }
      return new PReal(this.value / anotherInteger.value);
    }
    if (anothValue instanceof PReal anotherReal)
    {
      return new PReal(this.value / anotherReal.value);
    }
    return super.divide(anothValue);
  }
}

package vm.pobject;

public class PInteger extends PValue
{
  protected long value;

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

  @Override
  public PValue add(PValue anothValue)
  {
    if (anothValue instanceof PInteger anotherInteger)
    {
      return new PInteger(this.value + anotherInteger.value);
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
      return new PInteger(this.value - anotherInteger.value);
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
      return new PInteger(this.value * anotherInteger.value);
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
      return new PInteger(this.value / anotherInteger.value);
    }
    if (anothValue instanceof PReal anotherReal)
    {
      return new PReal(this.value / anotherReal.value);
    }
    return super.divide(anothValue);
  }
}

package vm.pobject;

public class PString extends PValue
{

  private String value;

  public PString(String value)
  {
    this.value = value;
  }

  @Override
  public int hashCode()
  {
    return this.value.hashCode();
  }

  @Override
  public boolean equals(Object obj)
  {
    if (obj instanceof PString pString)
    {
      return this.value.equals(pString.value);
    }

    return false;
  }

  @Override
  public int compareTo(PValue o)
  {
    if (o instanceof PString str)
    {
      return this.value.compareTo(str.value);
    }

    return 0;
  }

  @Override
  public String toString()
  {
    return this.value;
  }
}

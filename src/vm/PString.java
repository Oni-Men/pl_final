package vm;

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
}

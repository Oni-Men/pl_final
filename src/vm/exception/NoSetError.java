package vm.exception;

public class NoSetError extends VMError
{
  private String setName;

  public NoSetError(String setName)
  {
    this.setName = setName;
  }

  @Override
  public String getMessage()
  {
    return digest(quote(this.setName) + "は未定義です");
  }

}

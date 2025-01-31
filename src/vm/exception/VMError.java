package vm.exception;

public class VMError extends RuntimeException
{
  public VMError()
  {

  }

  public VMError(String message)
  {
    super(message);
  }

  protected String quote(String word)
  {
    return "\"" + word + "\"";
  }

  protected String digest(String message)
  {
    return this.getClass().getSimpleName() + ": " + message;
  }
}

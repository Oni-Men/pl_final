package vm.exception;

public class VMException extends RuntimeException
{
  public VMException()
  {

  }

  public VMException(String message)
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

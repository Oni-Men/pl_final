package vm.exception;

public class NoVariableError extends VMError
{
  private String variableName;

  public NoVariableError(String variableName)
  {
    this.variableName = variableName;
  }

  @Override
  public String getMessage()
  {
    return digest(quote(this.variableName) + "は不定な変数です");
  }
}

package vm;

import util.Bool;
import vm.exception.NoSetError;
import vm.pobject.PSet;

public class SetVariableExpression extends SetExpression
{

  private String setName;

  public SetVariableExpression(String setName)
  {
    this.setName = setName;
  }

  @Override
  public PSet evaluate(SymbolTable symbolTable)
  {
    PSet pSet = symbolTable.getAsSet(setName);
    Bool.of(pSet == null).throwIfTrue(() -> new NoSetError(setName));

    return pSet;
  }

  public String setName()
  {
    return this.setName;
  }
}

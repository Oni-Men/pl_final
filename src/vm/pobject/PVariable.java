package vm.pobject;

import vm.SymbolTable;

public class PVariable extends PValue
{

  private String symbolName;

  public PVariable(String symbolName)
  {
    this.symbolName = symbolName;
  }

  public PValue getSymbol(SymbolTable scope)
  {
    return scope.getAsValue(symbolName);
  }

  public String getSymbolName()
  {
    return this.symbolName;
  }

  @Override
  public boolean isVariable()
  {
    return true;
  }

}

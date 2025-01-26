package vm;

import vm.pobject.PSet;

public class SetDomainLimitExpression extends SetExpression
{
  private String domainName;
  private Number lowerBound;
  private Number upperBound;
  private Number step;

  public SetDomainLimitExpression(String domainName, Number lowerBound, Number upperBound, Number step)
  {
    this.domainName = domainName;
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
    this.step = step;
  }

  @Override
  public PSet evaluate(SymbolTable symbolTable)
  {
    PSet domainSet = symbolTable.getAsSet(domainName);
    if (domainSet == null)
    {
      throw new RuntimeException("No set: " + domainName);
    }

    return domainSet.limitDomain(lowerBound, upperBound, step);
  }
}

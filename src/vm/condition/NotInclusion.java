package vm.condition;

import parser.ast.Cell;
import util.Bool;
import vm.Evaluator;
import vm.SymbolTable;
import vm.exception.VMException;
import vm.pobject.PSet;
import vm.pobject.PValue;

public class NotInclusion extends Inclusion
{

  public NotInclusion(PValue setElement, Cell domainSetNotation)
  {
    super(setElement, domainSetNotation);
  }

  public NotInclusion(String variableName, Cell domainSetNotation)
  {
    super(variableName, domainSetNotation);
  }

  @Override
  public EvaluateResult evaluate(SymbolTable scope)
  {

    String boundVariableName = "__" + variableName();
    PSet domain = scope.getAsSet(boundVariableName);
    Bool.of(domain == null).throwIfTrue(() -> new VMException("集合が未定義: " + boundVariableName));

    PSet exclusion = Evaluator.handleNotation(this.domainSetNotation(), scope);
    PSet pSet = domain.difference(exclusion);

    return new EvaluateResult(variableName(), pSet, Bool.of(false), scope);
  }

}

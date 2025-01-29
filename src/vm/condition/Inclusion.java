package vm.condition;

import parser.ast.Cell;
import util.Bool;
import vm.Evaluator;
import vm.SymbolTable;
import vm.exception.VMException;
import vm.pobject.PSet;

public class Inclusion extends Relation
{

  private String variableName;
  private Cell domainSetNotation;

  public Inclusion(String variableName, Cell domainSetNotation)
  {
    this.variableName = variableName;
    this.domainSetNotation = domainSetNotation;
  }

  public String variableName()
  {
    return this.variableName;
  }

  public Cell domainSetNotation()
  {
    return this.domainSetNotation;
  }

  @Override
  public EvaluateResult evaluate(SymbolTable scope)
  {
    PSet domain = Evaluator.handleNotation(domainSetNotation, scope);
    Bool.of(domain == null).throwIfTrue(() -> new VMException("集合が未定義"));

    return new EvaluateResult("__" + this.variableName, domain, scope);
  }
}

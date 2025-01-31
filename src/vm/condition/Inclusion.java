package vm.condition;

import java.util.HashSet;
import java.util.Set;

import parser.ast.Cell;
import util.Bool;
import vm.Evaluator;
import vm.SymbolTable;
import vm.exception.VMException;
import vm.pobject.PSet;
import vm.pobject.PValue;
import vm.pobject.PVariable;

public class Inclusion extends Relation
{

  private PValue setElement;
  private Cell domainSetNotation;

  public Inclusion(PValue setElement, Cell domainSetNotation)
  {
    this.setElement = setElement;
    this.domainSetNotation = domainSetNotation;
  }

  public Inclusion(String variableName, Cell domainSetNotation)
  {
    this.setElement = new PVariable(variableName);
    this.domainSetNotation = domainSetNotation;
  }

  public String variableName()
  {
    if (setElement instanceof PVariable pVariable)
    {
      return pVariable.getSymbolName();
    }
    return null;
  }

  public PValue value()
  {
    return this.setElement;
  }

  public Cell domainSetNotation()
  {
    return this.domainSetNotation;
  }

  @Override
  public EvaluateResult evaluate(String elementName, SymbolTable scope)
  {
    PSet domain = Evaluator.handleNotation(domainSetNotation, scope);
    Bool.of(domain == null).throwIfTrue(() -> new VMException("集合が未定義"));

    // 集合要素が変数の場合，status = false．具体的な値の場合は，集合にふくまれるとき status = true，
    Bool noFreeVariables = Bool.of(this.setElement instanceof PVariable).not();
    Bool status = noFreeVariables
        .ifTrueElse(
            () -> domain.include(setElement),
            () -> Bool.of(false));

    // 包含関係は，変数名(elementName)を「x」としたとき，「__x」の集合を定義する
    String variableName = Bool.of(this.variableName() == null)
        .ifTrueElse(() -> elementName, () -> this.variableName());
    return new EvaluateResult("__" + variableName, domain, status, noFreeVariables, scope);
  }

  @Override
  public Set<PVariable> freeVariables()
  {
    Set<PVariable> freeVariables = new HashSet<>();
    if (this.setElement instanceof PVariable pVariable)
    {
      freeVariables.add(pVariable);
    }
    return freeVariables;
  }
}

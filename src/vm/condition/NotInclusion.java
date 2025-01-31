package vm.condition;

import parser.ast.Cell;
import util.Bool;
import vm.Evaluator;
import vm.SymbolTable;
import vm.exception.NoSetError;
import vm.exception.NoVariableError;
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
  public EvaluateResult evaluate(String elementName, SymbolTable scope)
  {
    PSet exclusion = Evaluator.handleNotation(this.domainSetNotation(), scope);

    // setElementが変数か具体的な値かで処理が分かれる
    if (this.variableName() == null)
    {
      // 「具体的な値が集合に包含されていない」という言明の場合
      // 例: 3!~A. (3という具体的な値)

      Bool status = exclusion.include(this.value()).not();
      PSet pSet = PSet.PHI;

      return new EvaluateResult(elementName, pSet, status, Bool.of(true), scope);
    }
    else
    {
      // 束縛変数名
      String boundVariableName = "__" + variableName();
      PSet domain = scope.getAsSet(boundVariableName);
      Bool.of(domain == null).throwIfTrue(() -> new NoVariableError(variableName()));
      PSet pSet = domain.difference(exclusion);

      return new EvaluateResult(boundVariableName, pSet, Bool.of(false), Bool.of(false), scope);
    }
  }

}

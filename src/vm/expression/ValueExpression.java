package vm.expression;

import parser.ast.Token;
import util.Cond;
import vm.SymbolTable;
import vm.pobject.PInteger;
import vm.pobject.PReal;
import vm.pobject.PString;
import vm.pobject.PValue;
import vm.pobject.PVariable;

import static parser.ast.TokenType.*;

import java.util.HashSet;
import java.util.Set;

public class ValueExpression extends MathExpression
{
  PValue value;

  public ValueExpression(Token token)
  {
    this.value = Cond
        .when(ID, () -> (PValue) new PVariable(token.text()))
        .or(NUMBER, () -> (PValue) new PInteger(token.text()))
        .or(REAL, () -> (PValue) new PReal(token.text()))
        .or(STRING, () -> (PValue) new PString(token.text(), true))
        .get(token.tokenType(), null);
  }

  public PValue evaluate(SymbolTable scope)
  {
    if (this.value instanceof PVariable pVariable)
    {
      return pVariable.getSymbol(scope);
    }
    return this.value;
  }

  @Override
  public Set<PVariable> freeVariables()
  {
    Set<PVariable> freeVriables = HashSet.newHashSet(1);
    if (this.value instanceof PVariable pVariable)
    {
      freeVriables.add(pVariable);
    }
    return freeVriables;
  }
}

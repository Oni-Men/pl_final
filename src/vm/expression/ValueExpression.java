package vm.expression;

import parser.ast.Token;
import util.Cond;
import vm.SymbolTable;
import vm.pobject.PInteger;
import vm.pobject.PReal;
import vm.pobject.PValue;
import vm.pobject.PVariable;

import static parser.ast.TokenType.*;

public class ValueExpression extends MathExpression
{
  PValue value;

  public ValueExpression(Token token)
  {
    this.value = Cond
        .when(ID, () -> (PValue) new PVariable(token.text()))
        .or(NUMBER, () -> (PValue) new PInteger(token.text()))
        .or(REAL, () -> (PValue) new PReal(token.text()))
        .get(token.tokenType(), null);
  }

  public PValue evaluate(SymbolTable scope)
  {
    return this.value;
  }
}

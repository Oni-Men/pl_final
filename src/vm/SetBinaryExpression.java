package vm;

import parser.ast.Token;
import parser.ast.TokenType;
import util.Cond;
import vm.pobject.PSet;

import static parser.ast.TokenType.*;

public class SetBinaryExpression extends SetExpression
{

  private Token operator;
  private SetExpression firstOperand;
  private SetExpression secondOperand;

  public SetBinaryExpression(Token operator, SetExpression firstOperand, SetExpression secondOperand)
  {
    this.operator = operator;
    this.firstOperand = firstOperand;
    this.secondOperand = secondOperand;
  }

  @Override
  public PSet evaluate(SymbolTable symbolTable)
  {
    PSet firstSet = firstOperand.evaluate(symbolTable);
    PSet secondSet = secondOperand.evaluate(symbolTable);

    return Cond
        .when((TokenType t) -> t == PLUS,
            () -> firstSet.union(secondSet))
        .or(t -> t == MINUS,
            () -> firstSet.difference(secondSet))
        .or(t -> t == MULTIPLY,
            () -> firstSet.intersect(secondSet))
        .or(t -> t == EXCLUSIVE,
            () -> firstSet.exclusive(secondSet))
        .get(operator.tokenType(), null);
  }

}

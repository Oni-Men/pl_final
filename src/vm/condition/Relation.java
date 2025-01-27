package vm.condition;

import parser.ast.Cell;
import parser.ast.Leaf;
import parser.ast.TokenType;
import util.Bool;
import util.Cond;
import vm.SymbolTable;
import vm.expression.MathExpression;
import vm.pobject.PValue;

public class Relation
{

  public static Relation of(Cell cell)
  {
    // 関係式の種類を判定する
    TokenType operator = cell.head().<Leaf>as().token().tokenType();

    // オペランドを解析
    MathExpression firstOperand = MathExpression.of(cell.tail().head());
    MathExpression secondOperand = MathExpression.of(cell.tail().next());

    // 関係式の種類に応じてインスタンスを作成
    Relation relation = Cond
        .when(
            (TokenType t) -> t == TokenType.EQUAL,
            () -> (Relation) new Equation(firstOperand, secondOperand))
        .or((TokenType t) -> t == TokenType.NOTEQ,
            () -> (Relation) new Equation(firstOperand, secondOperand, true))
        .or((TokenType t) -> t == TokenType.LT,
            () -> (Relation) new Inequation(operator, firstOperand, secondOperand))
        .or((TokenType t) -> t == TokenType.GT,
            () -> (Relation) new Inequation(operator, firstOperand, secondOperand))
        .or((TokenType t) -> t == TokenType.LE,
            () -> (Relation) new Inequation(operator, firstOperand, secondOperand))
        .or((TokenType t) -> t == TokenType.GE,
            () -> (Relation) new Inequation(operator, firstOperand, secondOperand))
        .get(operator, null);

    Bool.isNull(relation).throwIfTrue(() -> new RuntimeException("Invalid relation"));
    return relation;
  }

  public PValue evaluate(SymbolTable scope)
  {
    return null;
  }

}

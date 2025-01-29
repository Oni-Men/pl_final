package vm.condition;

import parser.ast.Cell;
import parser.ast.Leaf;
import parser.ast.TokenType;
import util.Bool;
import util.Cond;
import util.ConsUtil;
import vm.SymbolTable;
import vm.exception.VMException;
import vm.expression.MathExpression;

import static parser.ast.TokenType.*;

public abstract class Relation implements IEvaluable
{

  public static Relation of(Cell relation)
  {
    // 関係式の種類を判定する
    TokenType operator = relation.head().<Leaf>as().token().tokenType();
    return operator.is(IN).or(operator.is(NOTIN))
        .ifTrueElse(
            () -> Relation.ofInclusion(operator, relation.tail()),
            () -> Relation.ofMathExpression(operator, relation.tail()));
  }

  private static Relation ofInclusion(TokenType operator, Cell inclusion)
  {
    String variableName = ConsUtil.setElementName(inclusion.head());
    Cell domainSetExpression = inclusion.next();

    return new Inclusion(variableName, domainSetExpression);
  }

  private static Relation ofMathExpression(TokenType operator, Cell expressions)
  {
    // オペランドを解析
    MathExpression firstOperand = MathExpression.of(expressions.head());
    MathExpression secondOperand = MathExpression.of(expressions.next());

    // 関係式の種類に応じてインスタンスを作成
    Relation result = Cond
        .when(
            (TokenType t) -> t == EQUAL,
            () -> (Relation) new Equation(firstOperand, secondOperand))
        .or((TokenType t) -> t == NOTEQ,
            () -> (Relation) null)
        .or((TokenType t) -> t == LT,
            () -> (Relation) new Inequation(operator, firstOperand, secondOperand))
        .or((TokenType t) -> t == GT,
            () -> (Relation) new Inequation(operator, firstOperand, secondOperand))
        .or((TokenType t) -> t == LE,
            () -> (Relation) new Inequation(operator, firstOperand, secondOperand))
        .or((TokenType t) -> t == GE,
            () -> (Relation) new Inequation(operator, firstOperand, secondOperand))
        .get(operator, null);

    Bool.isNull(result).throwIfTrue(() -> new VMException("Invalid relation"));
    return result;
  }

  public EvaluateResult evaluate(SymbolTable scope)
  {
    throw new VMException("実装されていません");
  }

}

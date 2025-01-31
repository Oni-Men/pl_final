package vm.condition;

import parser.ast.Cell;
import parser.ast.Leaf;
import parser.ast.TokenType;
import util.Bool;
import util.Cond;
import vm.SymbolTable;
import vm.exception.VMError;
import vm.expression.MathExpression;
import vm.pobject.PValue;

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
    PValue setElement = PValue.fromSetElement(inclusion.head());
    Cell domainSetExpression = inclusion.next();

    return Cond
        .when(IN, () -> new Inclusion(setElement, domainSetExpression))
        .or(NOTIN, () -> new NotInclusion(setElement, domainSetExpression))
        .get(operator, null);
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

    Bool.isNull(result).throwIfTrue(() -> new VMError("Invalid relation"));
    return result;
  }

  public EvaluateResult evaluate(String elementName, SymbolTable scope)
  {
    throw new VMError("実装されていません");
  }

}

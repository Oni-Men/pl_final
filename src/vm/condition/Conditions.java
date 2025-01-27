package vm.condition;

import parser.ast.Cell;
import parser.ast.Leaf;
import parser.ast.Token;
import parser.ast.TokenType;
import util.Bool;
import util.Cond;
import vm.SetExpression;
import vm.SymbolTable;
import vm.pobject.PSet;
import vm.pobject.PValue;

import static parser.ast.TokenType.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conditions
{
  public enum LogicalOperationType
  {
    AND, OR
  }

  private String elementName;

  private LogicalOperationType logicalOperationType;
  private List<Conditions> conditions;
  private SymbolTable scope;

  public static PSet of(Cell setElement, Cell conditions, SymbolTable symbolTable)
  {
    // 集合元の変数名を求める
    String elementName = setElement.head().textEquals("lower_id", () -> setElement.next().text());
    Bool.isEmpty(elementName).throwIfTrue(() -> new RuntimeException("Invalid conditoin"));

    // 条件の種類を求める
    String logicType = conditions.head().head().text();
    PSet pSet = Cond
        .whenText(
            (s) -> s.equalsIgnoreCase("and"),
            () -> handleConjunction(elementName, conditions.head().tail(), symbolTable))
        .or(
            (s) -> s.equalsIgnoreCase("or"),
            () -> handleDisjunction(elementName, conditions.head().tail(), symbolTable))
        .get(logicType, null);

    Bool.isNull(pSet).throwIfTrue(() -> new RuntimeException("Invalid condition"));
    return pSet;
  }

  /**
   * 連言（AND）の処理を行う
   * 
   * @return
   */
  private static PSet handleConjunction(String elementName, Cell conjunction, SymbolTable outerScope)
  {
    // 関係式の種類
    TokenType relation1 = conjunction.head().head().<Leaf>as().token().tokenType();
    TokenType relation2 = conjunction.next().head().<Leaf>as().token().tokenType();

    Bool enumerate = Bool.of(relation1 == IN || relation2 == IN);
    enumerate.throwIfFalse(() -> new RuntimeException("Must have at least one inclusive relation"));

    if (Boolean.logicalAnd(relation1 == IN, relation2 == IN))
    {
      // 2つの帰属関係式における変数と集合をそれぞれ，(a, A)，(b,B)とする．
      // aとbがどちらもsetElementに一致したとき，生成される集合はAとBの積集合となる．
      // aとbの少なくとも片方がsetElementと不一致の場合，空集合となる．

      // TODO: タプルに対応する

      Cell inclusion1 = conjunction.head();
      Cell inclusion2 = conjunction.next();

      String variable1 = inclusion1.next().next().next().text();
      String variable2 = inclusion2.next().next().next().text();

      return Bool.of(variable1.equals(elementName)).and(Bool.of(variable2.equals(elementName)))
          .ifTrueElse(
              () -> {
                SetExpression setExpression1 = SetExpression.of(inclusion1.tail().next().next());
                SetExpression setExpression2 = SetExpression.of(inclusion2.tail().next().next());

                PSet set1 = setExpression1.evaluate(outerScope);
                PSet set2 = setExpression2.evaluate(outerScope);
                Bool.of(set1 == null || set2 == null).throwIfTrue(() -> new RuntimeException("Set is not defined"));

                return set1.intersect(set2);
              },
              () -> new PSet()); // 空集合を返す
    }

    if (Boolean.logicalXor(relation1 == IN, relation2 == IN))
    {
      // どちらかが帰属関係式になっている場合，帰属関係条件と，もう一つの条件にわける
      Cell inclusion = Bool.of(relation1 == IN).ifTrueElse(() -> conjunction.head(), () -> conjunction.next());
      Cell conditions = Bool.of(relation1 == IN).ifTrueElse(() -> conjunction.next(), () -> conjunction.head());

      // 帰属関係条件を展開する
      return expandInclusion(elementName, conditions, inclusion, outerScope);
    }

    throw new RuntimeException("Invalid condition");
  }

  /**
   * 選言（OR）の処理を行う
   * 
   * @return
   */
  private static PSet handleDisjunction(String elementName, Cell disjunction, SymbolTable outerScope)
  {
    // 関係式の種類
    Token relation1 = disjunction.head().head().<Leaf>as().token();
    Token relation2 = disjunction.next().head().<Leaf>as().token();

    System.out.println("handle 選言");
    return null;
  }

  private static PSet expandInclusion(String elementName, Cell conditions, Cell inclusion,
      SymbolTable outerScope)
  {
    String variableName = inclusion.next().next().next().text();
    SetExpression setExpression = SetExpression.of(inclusion.tail().next().next());
    PSet domain = setExpression.evaluate(outerScope);

    // 単一の関係式か条件列か
    String conditionName = conditions.head().text();
    Bool isSingle = Bool
        .of(conditionName.equalsIgnoreCase("and"))
        .or(conditionName.equalsIgnoreCase("or"))
        .not();

    // 単一条件の場合，変数展開を行う．具体的にはこう↓
    // P(y), y~N を P(1), P(2), P(3), ...
    PSet expanded = isSingle.ifTrue(() -> {
      List<PValue> values = new ArrayList<>();
      Relation relation = Relation.of(conditions);

      SymbolTable scope = outerScope.fork();
      for (PValue value : domain.values())
      {
        scope.put(variableName, value);
        // TODO 評価によって集合に追加するかどうかを確定させる
        relation.evaluate(scope);

        // 追加する処理
      }
      return PSet.fromIterator(values.iterator());
    });

    // 複合条件の場合，下位の条件に対して再帰的に展開を行う．
    isSingle.ifFalse(() -> {
      Cell firstCondition = null;
      Cell secondCondition = null;
    });

    return expanded;
  }

  public Conditions(String elementName, LogicalOperationType operationType, SymbolTable scope, Conditions... conditions)
  {
    this.elementName = elementName;
    this.logicalOperationType = operationType;
    this.scope = scope;
    this.conditions = Arrays.asList(conditions);
  }

  public Conditions(String elementName, LogicalOperationType operationType, SymbolTable scope,
      List<Conditions> conditions)
  {
    this.elementName = elementName;
    this.logicalOperationType = operationType;
    this.scope = scope;
    this.conditions = conditions;
  }

  private Conditions expand(PValue value)
  {
    List<Conditions> conditions = new ArrayList<>();
    LogicalOperationType type = LogicalOperationType.OR;

    return new Conditions(elementName, type, scope, conditions);
  }

  public PSet evaluate()
  {
    PSet pSet = new PSet();

    Bool.of(this.logicalOperationType == LogicalOperationType.AND)
        .ifTrue(() -> {

        });
    Bool.of(this.logicalOperationType == LogicalOperationType.OR)
        .ifTrue(() -> {
          this.conditions.forEach(cond -> {
            PSet evaluatedSet = cond.evaluate();
          });
        });

    return pSet;
  }
}

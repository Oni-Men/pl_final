package vm.condition;

import java.util.function.Predicate;
import java.util.stream.Stream;

import parser.ast.Cell;
import util.Cond;
import vm.SymbolTable;
import vm.pobject.PSet;

public interface IEvaluable
{

  public static class EvaluateResult
  {
    String variableName;
    PSet generatedSet;
    SymbolTable symbolTable;

    public EvaluateResult(String variableName, PSet generatedSet, SymbolTable symbolTable)
    {
      this.variableName = variableName;
      this.generatedSet = generatedSet;
      this.symbolTable = symbolTable;
    }

    public String variableName()
    {
      return this.variableName;
    }

    public PSet generatedSet()
    {
      return this.generatedSet;
    }

    public SymbolTable symbolTable()
    {
      return this.symbolTable;
    }
  }

  public static IEvaluable of(Cell evaluable)
  {
    Predicate<String> isRelation = s -> Stream
        .of("~", "!~", "=", "!=", "<", ">", "<=", ">=")
        .anyMatch(x -> s.equals(x));

    String evaluableType = evaluable.head().text();
    IEvaluable result = Cond
        .whenText(
            (s) -> s.equalsIgnoreCase("and") || s.equalsIgnoreCase("or"),
            () -> (IEvaluable) Conditions.of(evaluable))
        .or(
            isRelation,
            () -> (IEvaluable) Relation.of(evaluable))
        .get(evaluableType, null);
    return result;
  }

  EvaluateResult evaluate(SymbolTable scope);

}

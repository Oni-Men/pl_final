package vm.condition;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

import parser.ast.Cell;
import util.Bool;
import util.Cond;
import vm.SymbolTable;
import vm.pobject.PSet;
import vm.pobject.PVariable;

public interface IEvaluable
{

  public static class EvaluateResult
  {
    String variableName;
    PSet generatedSet;
    SymbolTable symbolTable;

    Bool status;
    Bool noFreeVariables;

    public EvaluateResult(String variableName, PSet generatedSet, Bool status, Bool noFreeVariables,
        SymbolTable symbolTable)
    {
      this.variableName = variableName;
      this.generatedSet = generatedSet;
      this.symbolTable = symbolTable;
      this.status = status;
      this.noFreeVariables = noFreeVariables;
    }

    public EvaluateResult(String variableName, PSet generatedSet, Bool status,
        SymbolTable symbolTable)
    {
      this(variableName, generatedSet, status, Bool.of(false), symbolTable);
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

    public Bool status()
    {
      return this.status;
    }

    public Bool noFreeVariables()
    {
      return this.noFreeVariables;
    }

    public void noFreeVariables(Bool value)
    {
      this.noFreeVariables = value;
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

  EvaluateResult evaluate(String elementName, SymbolTable scope);

  Set<PVariable> freeVariables();
}

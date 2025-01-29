package vm;

import static parser.ast.TokenType.ID;

import parser.ast.Cell;
import parser.ast.Leaf;
import util.Cond;
import vm.pobject.PSet;

public class Evaluator
{
  private Cell rootCell;
  private SymbolTable environment;

  StringBuffer output;

  public Evaluator(Cell cell, SymbolTable environment)
  {
    this.rootCell = cell;
    this.environment = environment;
  }

  private void initialize()
  {
    this.output = new StringBuffer();
  }

  public void perform()
  {
    this.initialize();

    if (rootCell.head() instanceof Leaf aLeaf)
    {
      if (aLeaf.token().tokenType() == ID)
      {
        String verb = aLeaf.token().text();
        if (verb.equalsIgnoreCase("assert"))
        {
          this.handleAssert(rootCell.tail());
          return;
        }
        else if (verb.equalsIgnoreCase("prove"))
        {
          this.handleProve(rootCell.tail());
          return;
        }
      }
    }

    throw new RuntimeException("parser error");
  }

  private void handleAssert(Cell cell)
  {
    String aSetName = this.nameOfSet(cell.head());
    PSet pSet = handleNotation(cell.next(), environment);
    this.environment().put(aSetName, pSet);
  }

  private void handleProve(Cell cell)
  {
  }

  private static PSet handleSetExpression(Cell cell, SymbolTable environment)
  {
    return SetExpression.of(cell.head()).evaluate(environment);
  }

  private String nameOfSet(Cell cell)
  {
    return cell.head().textEquals("upper_id", () -> {
      return cell.tail().head().text();
    }, true);
  }

  public String output()
  {
    return this.output.toString();
  }

  public SymbolTable environment()
  {
    return this.environment;
  }

  public static PSet handleNotation(Cell cell, SymbolTable symbolTable)
  {
    String notationType = cell.head().text();
    Cell notation = cell.tail();

    return Cond
        .when(
            (String s) -> s.equalsIgnoreCase("extension"),
            () -> PSet.fromExtension(notation))
        .or(
            (String s) -> s.equalsIgnoreCase("intension"),
            () -> PSet.fromIntension(notation, symbolTable))
        .or(
            (String s) -> s.equalsIgnoreCase("expression"),
            () -> handleSetExpression(notation, symbolTable))
        .get(notationType, null);
  }
}

package vm;

import static parser.ast.TokenType.ID;

import parser.ast.Cell;
import parser.ast.Leaf;
import parser.ast.Node;
import util.Bool;
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
    if (!(cell instanceof Node))
    {
      return;
    }

    Node node = (Node) cell;

    String aSetName = this.nameOfSet(node.head());
    String notationType = this.notationType(node.tail());

    Cell notation = node.tail().head().tail();

    Bool.of(notationType.equalsIgnoreCase("extension"))
        .ifTrue(() -> {
          PSet pSet = PSet.fromExtension(notation);
          this.environment().put(aSetName, pSet);
        });
    Bool.of(notationType.equalsIgnoreCase("intension"))
        .ifTrue(() -> {
          PSet pSet = PSet.fromIntension(notation, this.environment);
          this.environment().put(aSetName, pSet);
        });

    Bool.of(notationType.equalsIgnoreCase("expression"))
        .ifTrue(() -> {
          PSet pSet = handleSetExpression(notation);
          this.environment().put(aSetName, pSet);
        });
  }

  private void handleProve(Cell cell)
  {
    if (!(cell instanceof Node))
    {
      return;
    }

    Node node = (Node) cell;
  }

  private PSet handleSetExpression(Cell cell)
  {
    return SetExpression.of(cell.head()).evaluate(environment);
  }

  private String nameOfSet(Cell cell)
  {
    return cell.head().textEquals("upper_id", () -> {
      return cell.tail().head().text();
    }, true);
  }

  private String notationType(Cell cell)
  {
    return cell.head().head().text();
  }

  public String output()
  {
    return this.output.toString();
  }

  public SymbolTable environment()
  {
    return this.environment;
  }
}

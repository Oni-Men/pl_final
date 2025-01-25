package vm;

import parser.ast.Cell;
import parser.ast.Leaf;
import parser.ast.Node;
import util.Bool;

import static parser.ast.TokenType.*;

public class Evaluator
{
  private Node rootNode;
  private SymbolTable environment;

  StringBuffer output;

  public Evaluator(Node node, SymbolTable environment)
  {
    this.rootNode = node;
    this.environment = environment;
  }

  private void initialize()
  {
    this.output = new StringBuffer();
  }

  public void perform()
  {
    this.initialize();

    if (rootNode.head() instanceof Leaf aLeaf)
    {
      if (aLeaf.token().tokenType() == ID)
      {
        String verb = aLeaf.token().text();
        if (verb.equalsIgnoreCase("assert"))
        {
          this.handleAssert(rootNode.tail());
          return;
        }
        else if (verb.equalsIgnoreCase("prove"))
        {
          this.handleProve(rootNode.tail());
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
          PSet pSet = PSet.fromIntension(notation);
          this.environment().put(aSetName, pSet);
        });

    Bool.of(notationType.equalsIgnoreCase("expression"))
        .ifTrue(() -> {
          PSet pSet = handleSetExpression(notation.tail());
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
    return null;
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

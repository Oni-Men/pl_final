package parser;

import static parser.ast.TokenType.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import parser.ast.Cell;
import parser.ast.Leaf;
import parser.ast.Node;
import parser.ast.Token;
import parser.ast.TokenType;

/**
 * 文法
 * 
 * Program ::= List*
 * 
 * S-Exp ::= Atom | List
 * 
 * Atom ::= ID | NUMBER | REAL | = | < | > | <= | >= | + | - | * | /
 * 
 * List ::= "(" Exp* ")"
 * 
 */
public class Parser implements IParser
{
  private IScanner scanner;

  private Token currToken;
  private Token peekToken;

  public Parser(IScanner scanner)
  {
    this.scanner = scanner;
  }

  public Parser(String inputString)
  {
    this.scanner = new Scanner(inputString);
  }

  private void initialize()
  {
    this.readToken();
    this.readToken();
  }

  private void readToken()
  {
    this.currToken = peekToken;
    this.peekToken = this.scanner.next();
  }

  public List<Node> parse()
  {
    return parse(anException -> {
      anException.printStackTrace();
    });
  }

  /**
   * Program ::= List*
   * 
   * @param ifFail
   * @return
   */
  public List<Node> parse(Consumer<Exception> ifFail)
  {
    this.initialize();

    List<Node> program = new ArrayList<>();

    try
    {
      while (this.currToken != null && this.currToken.tokenType() != EOF)
      {
        Node list = this.parseList();
        program.add(list);
      }
    }
    catch (RuntimeException e)
    {
      ifFail.accept(e);
    }

    return program;
  }

  /**
   * List ::= "(" Exp* ")"
   * 
   * @return
   */
  private Node parseList()
  {
    if (currToken.tokenType() != LPAR)
    {
      throw new RuntimeException(this.errorMessage(currToken, "("));
    }
    this.readToken();

    Node listNode = new Node();
    Node currentNode = listNode;
    while (true)
    {
      Cell expression = this.parseExpression();
      if (expression == null)
      {
        break;
      }

      currentNode.head(expression);
      Node tail = new Node();
      currentNode.tail(tail);
      currentNode = tail;
    }

    if (currToken.tokenType() != RPAR)
    {
      throw new RuntimeException(this.errorMessage(currToken, ")"));
    }
    this.readToken();

    return listNode;
  }

  /**
   * S-Exp ::= Atom | List
   * 
   * @return
   */
  private Cell parseExpression()
  {
    if (this.currToken.tokenType() == LPAR)
    {
      return this.parseList();
    }
    else if (this.currToken.tokenType() == RPAR)
    {
      return null;
    }
    else
    {
      return this.parseAtom();
    }
  }

  /**
   * Atom ::= ID | NUMBER | REAL | = | < | > | <= | >= | + | - | * | /
   * 
   * @return
   */
  public Cell parseAtom()
  {
    Cell aCell = null;
    List<TokenType> symbols = Arrays.asList(
        ID, NUMBER, REAL, EQUAL, LT, GT, LE, GE, PLUS, MINUS, MULTIPLY, DIVIDE);

    if (symbols.contains(currToken.tokenType()))
    {
      aCell = new Leaf(this.currToken);
      this.readToken();
    }
    else
    {
      throw new RuntimeException(this.errorMessage(this.currToken));
    }

    return aCell;
  }

  private String errorMessage(Token token, String expected)
  {
    String errorMessage = this.errorMessage(token);
    return String.format("%s, expected %s", errorMessage, expected);
  }

  private String errorMessage(Token token)
  {
    String errorMessage = String.format("Unexpected token at line %d, column %d: %s",
        token.lineNumber(), token.columnCount(), token.text());

    return errorMessage;
  }

}

package parser;

import parser.ast.Token;
import parser.ast.TokenType;

public class Scanner
{
  public Scanner(String inputString)
  {

  }

  public Token next()
  {
    return new Token(TokenType.UNKNOWN, "");
  }
}

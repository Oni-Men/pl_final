package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import parser.ast.Token;
import parser.ast.TokenType;

public class Scanner implements IScanner
{

  private StringBuffer inputString;

  public Scanner(String inputString)
  {
    this.inputString = new StringBuffer(inputString);
  }

  public Token next()
  {
    Token aToken = null;
    while ((aToken = this.readToken()) != null)
    {
      if (aToken.tokenType() != TokenType.__)
      {
        break;
      }
    }
    return aToken;
  }

  private Token readToken()
  {
    for (TokenType tokenType : TokenType.values())
    {
      Pattern aPattern = tokenType.pattern();
      Matcher aMatcher = aPattern.matcher(this.inputString);

      if (aMatcher.find() && aMatcher.start() == 0)
      {
        String matchString = aMatcher.group();
        this.inputString.delete(0, aMatcher.end());
        return new Token(tokenType, matchString);
      }
    }

    if (this.inputString.isEmpty())
    {
      return new Token(TokenType.EOF, "");
    }

    return new Token(TokenType.UNKNOWN, "");
  }
}

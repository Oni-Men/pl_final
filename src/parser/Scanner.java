package parser;

import static parser.ast.TokenType.EOF;
import static parser.ast.TokenType.LINE_FEED;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import parser.ast.Token;
import parser.ast.TokenType;

public class Scanner implements IScanner
{

  private StringBuffer inputString;

  private Integer lineNumber;
  private Integer columnCount;

  public Scanner(String inputString)
  {
    this.inputString = new StringBuffer(inputString);
    this.lineNumber = Integer.valueOf(1);
    this.columnCount = Integer.valueOf(0);
  }

  public Token next()
  {
    Token aToken = null;
    while ((aToken = this.readToken()) != null && aToken.tokenType() != EOF)
    {
      if (aToken.tokenType() == TokenType.WHITESPACE)
      {
        continue;
      }
      if (aToken.tokenType() == TokenType.LINE_FEED)
      {
        continue;
      }

      break;
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

        if (tokenType == LINE_FEED)
        {
          this.lineNumber++;
          this.columnCount = 0;
        }

        Token aToken = new Token(tokenType, matchString);
        aToken.lineNumber(lineNumber);
        aToken.columnCount(this.columnCount);

        columnCount += matchString.length();
        return aToken;
      }
    }

    if (this.inputString.isEmpty())
    {
      return new Token(TokenType.EOF, "");
    }

    return new Token(TokenType.UNKNOWN, "");
  }
}

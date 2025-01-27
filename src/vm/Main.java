package vm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import parser.Parser;
import parser.Scanner;
import parser.ast.Cell;

public class Main
{
  public static void main(String[] args)
  {
    StringBuffer buffer = new StringBuffer();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
    {

      SymbolTable global = new SymbolTable();

      System.out.println("Hello, This is P~Set VM.");

      String line;
      while ((line = reader.readLine()) != null)
      {
        if (line.isEmpty())
        {
          var aScanner = new Scanner(buffer.toString());
          var aParser = new Parser(aScanner);
          var programs = aParser.parse();

          for (Cell cell : programs)
          {
            var anEvaluator = new Evaluator(cell, global);
            anEvaluator.perform();
            System.out.println(anEvaluator.output());
          }

          buffer.setLength(0);
        }
        else
        {
          buffer.append(line);
          buffer.append(System.lineSeparator());
        }
      }
    }
    catch (IOException exception)
    {
      exception.printStackTrace();
    }

  }
}

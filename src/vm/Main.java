package vm;

import parser.Parser;

public class Main
{
  public static void main(String[] args)
  {
    System.out.println("This is the VM main.");

    var aParser = new Parser();
    System.out.println(aParser);
  }
}

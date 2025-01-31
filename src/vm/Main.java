package vm;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.lang.ProcessBuilder.Redirect;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import gui.Terminal;
import parser.Parser;
import parser.Scanner;
import parser.ast.Cell;
import util.Bool;
import vm.exception.VMError;

public class Main
{
  InputStream inputStream;
  PrintStream outputStream;
  PrintStream errorStream;

  public Main(InputStream inputStream, PrintStream outputStream)
  {
    this(inputStream, outputStream, outputStream);
  }

  public Main(InputStream inputStream, PrintStream outputStream, PrintStream errorStream)
  {
    this.inputStream = inputStream;
    this.outputStream = outputStream;
    this.errorStream = errorStream;
  }

  public void run()
  {
    StringBuffer buffer = new StringBuffer();
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.inputStream)))
    {

      SymbolTable global = new SymbolTable();

      this.outputStream.println("Hello, This is P~Set VM.");

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
            try
            {
              var anEvaluator = new Evaluator(cell, global);
              anEvaluator.perform();
              this.outputStream.println(anEvaluator.output());
            }
            catch (VMError vmException)
            {
              this.errorStream.println(vmException.getMessage());
            }
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

  private static Map<String, String> parseArguments(String[] args)
  {
    Map<String, String> options = new HashMap<>();
    Iterator<String> anIterator = Stream.of(args).iterator();

    while (anIterator.hasNext())
    {
      String argument = anIterator.next();
      if (argument.startsWith("--"))
      {
        if (anIterator.hasNext())
        {
          String nextArgument = anIterator.next();
          options.put(argument.substring(2), nextArgument);
        }
      }
    }

    return options;
  }

  public static Process executeFront(boolean inherit)
  {
    List<String> treeBinaryPaths = Arrays.asList("./front/tree", "tree");
    for (String treeBinaryPath : treeBinaryPaths)
    {
      File treeBinaryFile = new File(treeBinaryPath);
      if (!treeBinaryFile.exists())
      {
        continue;
      }

      ProcessBuilder processBuilder = new ProcessBuilder(treeBinaryFile.getAbsolutePath());
      if (inherit)
      {
        processBuilder.redirectInput(Redirect.INHERIT);
      }
      processBuilder.redirectErrorStream(true);

      try
      {
        Process process = processBuilder.start();

        return process;
      }
      catch (IOException e)
      {
        break;
      }
    }

    System.err.println("Failed to execute front binary.");
    System.exit(-1);

    return null;
  }

  private static void start()
  {
    Process frontProcess = executeFront(true);
    Main application = new Main(frontProcess.getInputStream(), System.out, System.err);

    application.run();
  }

  private static void startGUI()
  {
    Process frontProcess = executeFront(false);
    try
    {
      PipedInputStream pipeIn = new PipedInputStream();
      PipedOutputStream pipeOut = new PipedOutputStream(pipeIn);
      PrintStream outStream = new PrintStream(pipeOut);

      Main application = new Main(frontProcess.getInputStream(), outStream, System.err);

      new Thread(() -> {
        Terminal.open(pipeIn, frontProcess.getOutputStream());
      }).start();

      application.run();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public static void main(String[] args)
  {
    Map<String, String> options = parseArguments(args);
    start();
    // Bool.of(Boolean.parseBoolean(options.get("gui")))
    // .ifTrueElse(
    // () -> {
    // startGUI();
    // },
    // () -> {
    // start();
    // });
  }
}

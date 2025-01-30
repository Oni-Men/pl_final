package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Terminal extends JPanel
{
  private InputStream inputStream;
  private OutputStream outputStream;
  private PrintStream writer;

  private TerminalController controller;

  private JTextArea textarea;

  public Terminal(InputStream inputStream, OutputStream outputStream)
  {
    this.inputStream = inputStream;
    this.outputStream = outputStream;

    this.controller = new TerminalController(this);
    this.addMouseListener(this.controller);

    this.textarea = createTextArea();
    var scrollPane = createScrollPane();
    scrollPane.setViewportView(textarea);

    this.setLayout(new BorderLayout());
    this.add(scrollPane, BorderLayout.CENTER);

    this.textarea.setComponentPopupMenu(new PopupMenu(this));

    new Thread(() -> this.readFromStream()).start();
  }

  public void executeSelection()
  {
    String selection = this.textarea.getSelectedText();

    if (this.writer == null)
    {
      this.writer = new PrintStream(outputStream, true);
    }

    this.writer.println(selection);
    this.writer.flush();
    this.writer.close();
  }

  private void readFromStream()
  {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)))
    {
      String line;
      while ((line = reader.readLine()) != null)
      {
        this.textarea.append(line);
        this.textarea.append("\n");
        this.textarea.setCaretPosition(this.textarea.getText().length());
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  static JTextArea createTextArea()
  {
    JTextArea textarea = new JTextArea();
    textarea.setLineWrap(true);
    textarea.setWrapStyleWord(true);
    textarea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));

    return textarea;
  }

  static JScrollPane createScrollPane()
  {
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

    return scrollPane;
  }

  public static Terminal open(InputStream inputStream, OutputStream outputStream)
  {
    JFrame frame = new JFrame("P~Set Terminal");
    Terminal terminal = new Terminal(inputStream, outputStream);

    frame.getContentPane().add(terminal, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(500, 700);
    frame.setVisible(true);

    return terminal;
  }

}

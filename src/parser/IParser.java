package parser;

import java.util.List;

import parser.ast.Node;

public interface IParser
{

  List<Node> parse();

}

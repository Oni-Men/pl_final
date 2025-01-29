package util;

import parser.ast.Cell;
import vm.exception.VMException;

public class ConsUtil
{

  public static String setElementName(Cell cell)
  {
    Bool.of(cell.head().text().equalsIgnoreCase("setelement"))
        .throwIfFalse(() -> new VMException("SETELEMENTではありません"));

    Bool.of(cell.next().head().text().equalsIgnoreCase("lower_id"))
        .throwIfFalse(() -> new VMException("LOWER_IDではありません"));

    return cell.next().next().text();
  }

}

package gui;

import java.awt.event.ActionEvent;
import java.util.function.Consumer;

import javax.swing.AbstractAction;
import javax.swing.JPopupMenu;

public class PopupMenu extends JPopupMenu
{

  private Terminal view;

  public PopupMenu(Terminal view)
  {
    super();
    this.view = view;
    this.initialize();
  }

  private void initialize()
  {
    this.addMenuItem("実行", (_) -> view.executeSelection());
  }

  public void addMenuItem(String menuItemName, Consumer<ActionEvent> handler)
  {
    this.add(new AbstractAction(menuItemName)
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        handler.accept(e);
      }
    });
  }
}

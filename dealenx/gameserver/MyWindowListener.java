package dealenx.gameserver;

import java.awt.*;
import java.awt.event.*;

public class MyWindowListener extends WindowAdapter{
  MyFrame frame;
  public void windowClosing(WindowEvent e) {
    System.exit(0);

  }
  public MyWindowListener(MyFrame frame) {
    this.frame = frame;
  }

}

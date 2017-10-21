package dealenx.gui;

import java.awt.*;
import java.awt.event.*;


public class MyActionListener implements ActionListener{
  MyFrame frame;
  public void actionPerformed(ActionEvent e) {
    System.out.println("Onclick");
    frame.setTitle("My First Frame");
  }
  public MyActionListener(MyFrame frame) {
    this.frame = frame;
  }

}

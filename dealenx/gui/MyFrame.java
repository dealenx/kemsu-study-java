package dealenx.gui;

import java.awt.*;
import java.awt.event.*;


public class MyFrame extends Frame {
  Button b = new Button("MyButton");
  Panel p = new Panel();

  public MyFrame() {
    p.add(b);
    add(p);

    setTitle("MyFirstFrame");
    setSize(500,500);
    System.out.println("Start app");
    setVisible(true);
    System.out.println("Finish app");
  }




}

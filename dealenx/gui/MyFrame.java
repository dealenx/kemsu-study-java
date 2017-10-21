package dealenx.gui;

import java.awt.*;
import java.awt.event.*;


public class MyFrame extends Frame {
  Button leftBut = new Button("MyButton");
  Button topBut = new Button("MyButton");
  Button rightBut = new Button("MyButton");
  Button bottomBut = new Button("MyButton");
  MyCanvas vanvas = new MyCanvas();
  Panel p = new Panel();

  public MyFrame() {
    p.setLayout(new BorderLayout());
    p.add(leftBut, BorderLayout.WEST);
    p.add(topBut, BorderLayout.NORTH);
    p.add(rightBut, BorderLayout.EAST);
    p.add(bottomBut, BorderLayout.SOUTH);
    p.add(pa, BorderLayout.CENTER);

    leftBut.addActionListener( new MyActionListener(this) );
    addWindowListener(new MyWindowListener(this));
    add(p);

    setTitle("MyFirstFrame");
    setSize(500,500);
    System.out.println("Start app");
    setVisible(true);
    System.out.println("Finish app");
  }

}

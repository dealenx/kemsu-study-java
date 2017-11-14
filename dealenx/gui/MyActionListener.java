package dealenx.gui;

import java.awt.*;
import java.awt.event.*;

class MyActionListener implements ActionListener {
    Frame frame;
    MyCanvas canvas;

    public MyActionListener(Frame frame, MyCanvas canvas) {
        this.frame = frame;
        this.canvas = canvas;
    }

    public void actionPerformed(ActionEvent e) {

    }

}
/*
public class MyActionListener implements ActionListener{
  MyFrame frame;
  public void actionPerformed(ActionEvent e) {

    frame.setTitle("My First Frame");

    if (e.getActionCommand().equals("Vote figure")) {
      System.out.println("Vote figure");

    }
    if (e.getActionCommand().equals("To left")) {
      System.out.println("To left");
    }
  }
  public MyActionListener(MyFrame frame) {
    this.frame = frame;
  }

}*/

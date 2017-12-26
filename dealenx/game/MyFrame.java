package dealenx.game;

import java.awt.*;
import java.awt.event.*;


public class MyFrame extends Frame {
  Physic physic = new Physic();
  MyCanvas canvas = new MyCanvas();
  MyThread t1=new MyThread("RollingBall", canvas);
  PlThread pt = new PlThread ("Stick", canvas);


  Panel p = new Panel();
  Panel top = new Panel();
  Panel bottom = new Panel();

  Button butStart= new Button("Start");
  Button butSave= new Button("Save");
  Button butLoad= new Button("Load");
  Button butExit= new Button("Exit");
  Label labelStatus = new Label("Hi There!");

  public MyFrame(int windowWidth, int windowHeight) {

    p.setLayout(new BorderLayout());
    top.setLayout(new GridLayout(1,4));
    top.add(butStart);
    top.add(butSave);
    top.add(butLoad);
    top.add(butExit);
    bottom.setBackground(Color.gray);
    bottom.setLayout(new GridLayout(1,1));
    bottom.add(labelStatus);
    labelStatus.setAlignment(Label.CENTER);

    butStart.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("But start");
            t1.start();
            pt.start();
        }
    });
    butExit.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("But exit");
            System.exit(0);
        }
    });

    p.add(top, BorderLayout.NORTH);
    p.add(canvas, BorderLayout.CENTER);
    p.add(bottom, BorderLayout.SOUTH);


    addWindowListener(new MyWindowListener(this)); //Закрытие программы
    add(p);

    setTitle("MyFirstFrame");
    //setMinimumSize(new Dimension(windowWidth, windowHeight));
    setSize(windowWidth, windowHeight);
    System.out.println("Start app");
    setVisible(true);
    System.out.println("Finish app");
  }

}

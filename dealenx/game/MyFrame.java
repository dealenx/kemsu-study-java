package dealenx.game;

import java.awt.*;
import java.awt.event.*;
import dealenx.game.backend.*;

public class MyFrame extends Frame{

  MyCanvas canvas;
  MyThread t1;
  MyThread pt;
  Physic physic;


  Panel p = new Panel();
  Panel top = new Panel();
  Panel bottom = new Panel();

  Button butStart= new Button("Start");
  Button butSave= new Button("Save");
  Button butLoad= new Button("Load");
  Button butExit= new Button("Exit");
  Label labelStatus = new Label("Hi There!");

  public MyFrame() {
    physic = new Physic(1000,600);
    canvas = new MyCanvas(physic);
    t1 = new MyThread("Ball", physic, canvas);
    pt = new MyThread("Platform", physic, canvas);

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
            t1.resume();
            pt.resume();
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
    setSize(physic.getWidthWindow(), physic.getHeightWindow());
    System.out.println("Start app");
    setVisible(true);
    System.out.println("Finish app");
  }

}

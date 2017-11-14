package dealenx.gui;

import java.awt.*;
import java.awt.event.*;


public class MyFrame extends Frame {

  Button topBut = new Button("top");
  Button lefttBut = new Button("left");
  Button bottomBut = new Button("bottom");
  MyCanvas canvas = new MyCanvas();


  Panel p = new Panel();
  Panel top = new Panel();

  Panel panelVote = new Panel();
  List selectFigure = new List(2,false);
  Button butVote = new Button("Vote figure");

  Panel panelMove = new Panel();
  Button butTopMove = new Button("To top");
  Button butLeftMove = new Button("To left");
  Button butRightMove = new Button("To right");
  Button butBottomMove = new Button("To bottom");

  Panel panelSize = new Panel();
  Button butCompress = new Button("to compress");
  Button butExtend = new Button("to extend");

  Panel panelRotation = new Panel();
  Button butCW = new Button("clockwise");
  Button butCCW = new Button("counter-clockwise");

  public MyFrame() {
    selectFigure.add("Circle");
    selectFigure.add("Triangle");
    selectFigure.add("Rectangle");

    p.setLayout(new BorderLayout());
    top.setLayout(new GridLayout(1,5));
    top.add(panelVote);
    top.add(panelMove);
    top.add(panelSize);
    top.add(panelRotation);
    top.add(new Button("Animation"));

    panelVote.setLayout(new GridLayout(2,1));
    panelVote.add(selectFigure);
    panelVote.add(butVote);

    butVote.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Vote a figure");
        }
    });

    panelMove.setLayout(new GridLayout(2,2));
    panelMove.add(butLeftMove);
    butLeftMove.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("butLeftMove");
        }
    });
    //butLeftMove.addActionListener( new MyActionListener(this) );
    panelMove.add(butRightMove);
    panelMove.add(butTopMove);
    panelMove.add(butBottomMove);

    panelSize.setLayout(new GridLayout(2,1));
    panelSize.add(butCompress);
    panelSize.add(butExtend);

    panelRotation.setLayout(new GridLayout(2,1));
    panelRotation.add(butCW);
    panelRotation.add(butCCW);


    p.add(top, BorderLayout.NORTH);

    p.add(canvas, BorderLayout.CENTER);


    addWindowListener(new MyWindowListener(this)); //Закрытие программы
    add(p);

    setTitle("MyFirstFrame");
    setMinimumSize(new Dimension(700, 400));
    //setSize(500,500);
    System.out.println("Start app");
    setVisible(true);
    System.out.println("Finish app");
  }

}

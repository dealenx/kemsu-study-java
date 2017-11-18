package dealenx.gui;

import java.awt.*;
import java.awt.event.*;


public class MyFrame extends Frame {

  Button butStart= new Button("Start");
  MyCanvas canvas = new MyCanvas();
  MyThread t1=new MyThread("RollingBall", canvas);

  Panel p = new Panel();
  Panel top = new Panel();

  Panel panelVote = new Panel();
  Button butVoteCircle = new Button("Vote Circle");
  Button butVoteRectangle = new Button("Vote Rectangle");

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

    p.setLayout(new BorderLayout());
    top.setLayout(new GridLayout(1,5));
    top.add(panelVote);
    top.add(panelMove);
    top.add(panelSize);
    top.add(panelRotation);
    top.add(butStart);

    butStart.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("But start");
            t1.start();
        }
    });

    panelVote.setLayout(new GridLayout(2,1));
    panelVote.add(butVoteCircle);
    butVoteCircle.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Vote a figure Circle");
            canvas.voteCircle();
            canvas.repaint();
        }
    });
    panelVote.add(butVoteRectangle);
    butVoteRectangle.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("Vote a figure Rect");
            canvas.voteRectangle();
            canvas.repaint();
        }
    });

    panelMove.setLayout(new GridLayout(2,2));
    panelMove.add(butLeftMove);
    butLeftMove.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("butLeftMove");
            canvas.leftMove();
            canvas.repaint();
        }
    });
    panelMove.add(butRightMove);
    butRightMove.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("butRightMove");
            canvas.rightMove();
            canvas.repaint();
        }
    });
    panelMove.add(butTopMove);
    butTopMove.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("butTopMove");
            canvas.topMove();
            canvas.repaint();
        }
    });
    panelMove.add(butBottomMove);
    butBottomMove.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("butBottomMove");
            canvas.bottomMove();
            canvas.repaint();
        }
    });

    panelSize.setLayout(new GridLayout(2,1));
    panelSize.add(butCompress);
    butCompress.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("butCompress");
            canvas.doCompress();
            canvas.repaint();
        }
    });
    panelSize.add(butExtend);
    butExtend.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("butExtend");
            canvas.doExtend();
            canvas.repaint();
        }
    });

    panelRotation.setLayout(new GridLayout(2,1));
    panelRotation.add(butCW);
    butCW.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("butCW");
            canvas.doCW();
            canvas.repaint();
        }
    });
    panelRotation.add(butCCW);
    butCCW.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("butCCW");
            canvas.doCCW();
            canvas.repaint();
        }
    });


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

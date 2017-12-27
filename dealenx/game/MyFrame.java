package dealenx.game;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import dealenx.game.backend.*;

public class MyFrame extends Frame {

  private MyCanvas canvas;
  private MyThread t1;
  private MyThread pt;
  private Physic physic;
  //private Physic physic2;

  private boolean pause;
  private boolean lose;


  private Panel p = new Panel();
  private Panel top = new Panel();
  private Panel bottom = new Panel();

  private Button butStart= new Button("Start");
  private Button butSave= new Button("Save");
  private Button butLoad= new Button("Load");
  private Button butExit= new Button("Exit");
  private Label labelStatus = new Label("Hi There!");

  public MyFrame() {
    pause = true;
    lose = false;
    physic = new Physic(1000,600);

    //physic2 = new Physic(1000,600);
    canvas = new MyCanvas(physic);
    t1 = new MyThread("Ball", physic, canvas, this);
    pt = new MyThread("Platform", physic, canvas, this);

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

            if(pause) {
              System.out.println("But start");
              physic.resume();
              butStart.setLabel("Pause");
              pause = false;
            } else {
              System.out.println("But pause");
              physic.pause();
              butStart.setLabel("Start");
              pause = true;
            }

        }
    });
    butExit.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("But exit");
            System.exit(0);
        }
    });
    butLoad.addActionListener(new MyActionListener(this, canvas) {
        public void actionPerformed(ActionEvent e) {
            System.out.println("But load");
            loadData();
            /*physic.setXBall(1);
            physic.setYBall(1);*/
        }
    });
    butSave.addActionListener(new MyActionListener(this, canvas)  {
        public void actionPerformed(ActionEvent e)  {
            System.out.println("But save");
            saveData();

        }
    });

    p.add(top, BorderLayout.NORTH);
    p.add(canvas, BorderLayout.CENTER);
    p.add(bottom, BorderLayout.SOUTH);


    addWindowListener(new MyWindowListener(this)); //Закрытие программы
    add(p);

    setTitle("MyFirstFrame");
    setSize(physic.getWidthWindow(), physic.getHeightWindow());
    setResizable(false);
    System.out.println("Start app");
    setVisible(true);
    System.out.println("Finish app");
  }
  public void pause() {
    physic.pause();
  }
  public void resume() {
    physic.resume();
  }
  public void saveData() {
    try {
      Object objSave = physic;

      File f= new File("./data/game.dat");
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
      out.writeObject(objSave);
      out.close();
    } catch(IOException er) {
      System.out.println("Error save physic");
    }
  }
  public void loadData() {
    try {
			File f= new File("./data/game.dat");
      Physic loadphysic;

      ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
      loadphysic = (Physic)in.readObject();
      physic.setXBall( loadphysic.getXBall() );
      physic.setYBall( loadphysic.getYBall() );
      in.close();
		} catch(Exception IOException) {
			System.out.println("Error load");
		}
  }
  public void loseGame() {
    labelStatus.setText("You lose");
    butStart.setLabel("Start New Game");
    pause();
    System.exit(0);
  }
  public void setStatus(boolean status) {
    lose = status;

    if(lose) {
      loseGame();
    }
  }

}

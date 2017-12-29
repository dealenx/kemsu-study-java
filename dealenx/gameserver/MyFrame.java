package dealenx.gameserver;

import java.io.IOException;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.awt.*;
import java.awt.event.*;
import dealenx.gameserver.backend.*;

public class MyFrame extends Frame {

  private MyCanvas canvas;
  private MyThread t1;
  private MyThread pt;
  private Physic physic;

  private boolean pause;
  private boolean lose;


  private Panel p = new Panel();
  private Panel top = new Panel();
  private Panel bottom = new Panel();

  private Button butStart= new Button("Start");
  private Button butLoad= new Button("Load");
  private Button butExit= new Button("Exit");
  private Label labelStatus = new Label("Hi There!");

  private Socket socket = null;
	private ObjectInputStream inputStream = null;
	private ObjectOutputStream outputStream = null;
	private boolean isConnected = false;

  public MyFrame() {
    pause = true;
    lose = false;
    physic = new Physic(1000,600);

    canvas = new MyCanvas(physic);
    t1 = new MyThread("Ball", physic, canvas, this);
    pt = new MyThread("Platform", physic, canvas, this);

    p.setLayout(new BorderLayout());
    top.setLayout(new GridLayout(1,3));
    top.add(butStart);
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
            communicate();
            /*physic.setXBall(1);
            physic.setYBall(1);*/
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
  public void communicate() {

		while (!isConnected) {
			try {
				socket = new Socket("localHost", 4445);
				System.out.println("Connected");
				isConnected = true;

				outputStream = new ObjectOutputStream(socket.getOutputStream());
				inputStream = new ObjectInputStream(socket.getInputStream());
				Physic message2;

					message2 = (Physic) inputStream.readObject();

					System.out.println("Object y = " + message2.getYBall() + "x = " + message2.getXBall());
          physic.setXBall(message2.getXBall());
          physic.setYBall(message2.getYBall());


			} catch (SocketException se) {
				se.printStackTrace();
			// System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException cn) {
				cn.printStackTrace();
			}
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

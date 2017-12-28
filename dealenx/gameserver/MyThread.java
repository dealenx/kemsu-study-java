package dealenx.gameserver;

import java.awt.*;
import java.awt.event.*;
import dealenx.gameserver.backend.*;


class  MyThread  implements Runnable{
  private String name;
  private MyCanvas canvas;
  private Physic physic;
  private MyFrame frame;
  private Thread thrd;
  private boolean suspended;
  private boolean stopped;

    public MyThread(String name, Physic physic, MyCanvas canvas, MyFrame frame){
      this.name = name;
      this.frame = frame;
      this.canvas= canvas;
      this.physic= physic;
      thrd = new Thread(this, name);
      suspended = false;
      stopped = false;
      thrd.start();
    }
    public synchronized void run(){
        System.out.println(this);
        if(this.name == "Ball") {
        while(true) {

            try {

                Thread.sleep(1);
                synchronized (this) {
                  physic.premove();
                  canvas.repaint();

                  frame.setStatus(physic.getStatus());

                  while (suspended)
                    wait();
                  if (stopped)
                    break;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          }
        }
        if(this.name == "Platform") {
          while(true) {
              try {
                  canvas.repaint();
                  canvas.movep();
                  Thread.sleep(1);

                  synchronized (this) {
                    while (suspended)
                      wait();
                    if (stopped)
                      break;
                  }

              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        }
    }
    public synchronized void stop() {
      stopped = true;
      suspended = false;
      notify();
      System.out.println(" stop()");
    }

    public synchronized void suspend() {
      suspended = true;
      System.out.println(" suspend()");
    }

    public synchronized void resume() {
      suspended = false;
      notify();
      System.out.println(" resume()");
    }

}

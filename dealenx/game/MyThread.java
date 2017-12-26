package dealenx.game;

import java.awt.*;
import java.awt.event.*;
import dealenx.game.backend.*;

class  MyThread  implements Runnable{
  String name;
  MyCanvas canvas;
  Physic physic;
  Thread thrd;
  boolean suspended;
  boolean stopped;

    public MyThread(String name, Physic physic, MyCanvas canvas){
      this.name = name;
      this.canvas= canvas;
      this.physic= physic;
      thrd = new Thread(this, name);
      suspended = true;
      stopped = false;
      thrd.start();
    }
    public synchronized void run(){
        System.out.println(this);
        boolean f=true;
        if(this.name == "Ball") {
        while(f) {

            try {
                physic.premove();
                Thread.sleep(1);
                synchronized (this) {
                  while (suspended)
                    wait();
                  if (stopped)
                    break;
                }
                canvas.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          }
        }
        if(this.name == "Platform") {
          while(f) {
              try {
                canvas.movep();

                  Thread.sleep(1);
                  synchronized (this) {
                    while (suspended)
                      wait();
                    if (stopped)
                      break;
                  }
                  canvas.repaint();
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

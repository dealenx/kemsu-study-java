package dealenx.game;

import java.awt.*;
import java.awt.event.*;
import dealenx.game.backend.*;

class  PlThread  implements Runnable{
  private String name;
  private MyCanvas canvas;
  private Physic physic;
  private Thread thrd;
  private boolean suspended;
  private boolean stopped;

    public PlThread(String name, Physic physic, MyCanvas canvas){
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

        if(this.name == "Platform") {
          while(f) {
              try {

                  Thread.sleep(1);

                  synchronized (this) {
                    canvas.repaint();
                    canvas.movep();
                    while (suspended)
                      pauseLock.wait();
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

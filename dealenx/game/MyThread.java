package dealenx.game;

import java.awt.*;
import java.awt.event.*;

class  MyThread extends Thread{
    String name;
    MyCanvas canvas;
    public MyThread(String name, MyCanvas canvas){
        super(name);
        this.canvas= canvas;
    }
    public synchronized void run(){  //вызвать start в main, он вызывает run
        System.out.println(this);
        boolean f=true;
        while(f) {
            canvas.premove();
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            canvas.repaint();
        }
    }

}

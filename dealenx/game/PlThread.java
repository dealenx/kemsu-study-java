package dealenx.game;

import java.awt.*;
import java.awt.event.*;


class  PlThread extends Thread{
    String name;
    MyCanvas canvas;
    public PlThread(String name, MyCanvas canvas){
        super(name);
        this.canvas= canvas;
    }
    public synchronized void run(){  //вызвать start в main, он вызывает run
        System.out.println(this);
        boolean f=true;
        while(f) {
            canvas.movep();


            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            canvas.repaint();
        }
    }

}

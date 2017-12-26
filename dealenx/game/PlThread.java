package dealenx.game;

import java.awt.*;
import java.awt.event.*;
import dealenx.game.backend.*;


class  PlThread extends Thread{
    String name;
    MyCanvas canvas;
    Physic physic;

    public PlThread(String name, Physic physic, MyCanvas canvas){
        super(name);
        this.canvas= canvas;
        this.physic= physic;
    }
    public synchronized void run(){
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

package dealenx.game;

import java.awt.*;
import java.awt.event.*;
import dealenx.game.backend.*;

class  MyThread extends Thread{
    String name;
    MyCanvas canvas;
    Physic physic;

    public MyThread(String name, Physic physic, MyCanvas canvas){
        super(name);
        this.canvas= canvas;
        this.physic= physic;
    }
    public synchronized void run(){
        System.out.println(this);
        boolean f=true;
        while(f) {
            physic.premove();
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            canvas.repaint();
        }
    }

}

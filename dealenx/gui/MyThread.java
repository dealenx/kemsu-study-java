package dealenx.gui;

import java.awt.*;
import java.awt.event.*;

class  MyThread extends Thread{
    String name;
    public MyThread(String name){
        super(name);
    }
    public void run(){  //вызвать start в main, он вызывает run
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

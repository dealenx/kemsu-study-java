package dealenx.gui;

import java.awt.*;
import java.awt.event.*;


class MyCanvas extends Canvas {
    int x, y, my, mx,sx,sy;
    int xp, yp ,sxp, syp;

    public MyCanvas() {
        super();
        x = 175;
        y = 150;
        my = 1;
        mx = 1;
        sx=25;
        sy=25;
        //xp = 150;
        //yp = 310;
        sxp = 100;
        syp = 10;
    }

    public void setBall(int width, int height){
        x = width/2;
        y = height/2;
    }

    public void SetSticker(int width, int height){
        xp = width/2 - sxp;
        yp = height - syp * 10;
    }

    public void harder(){
        my += 1;
        mx += 1;
        if (my >= 4 && mx >= 4) {
            mx = 4;
            my = 4;
        }
    }

    public void easier(){
        my -= 1;
        mx -= 1;
        if (my == 0 && mx == 0) {
            mx = 1;
            my = 1;
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.orange);
        g.fillOval(x,y,sx,sy);
    }

    public void premove(){

        if (x+sx <= 20||x + sx >=getWidth())
        {
            mx=-mx;
            move();
        }
        if (y+sy >=getHeight())
        {
          my=-my;
          move();
        }
        if (y+sy <=40) {
            my=-my;
            move();
        }
        else {
            move();
        }


    }

    public void move(){

        x+=mx;
        y+=my;
    }
}

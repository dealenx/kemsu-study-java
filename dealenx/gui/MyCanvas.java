package dealenx.gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;


class MyCanvas extends Canvas {
    private int x, y, my, mx,sizeX,sizeY;
    private int xp, yp ,sxp, syp;
    public int choice;
    public double gradus;


    public MyCanvas() {
        super();
        x = 200;
        y = 50;
        my = 1;
        mx = 1;
        sizeX=50;
        sizeY=50;
        choice = 2;
        gradus = 2*Math.PI;
        //xp = 150;
        //yp = 310;
    }

    public void setBall(int width, int height){
        x = width/2;
        y = height/2;
    }


    public void paint(Graphics g) {
        /*g.setColor(Color.orange);
        g.fillOval(x,y,sizeX,sizeY);*/

Graphics2D g2d = (Graphics2D) g.create();
        g2d.rotate(gradus);
        //g2d.translate((-1)*y,( -1*(1 + (y/x)))*x);
        if(choice == 1) {
          g2d.fillRect(x,y,sizeX,sizeY);
        } else {
          g2d.fillOval(x,y,sizeX,sizeY);
        }
        g2d.dispose();
    }

    public void premove(){

        if (x+sizeX <= 20||x + sizeX >=getWidth())
        {
            mx=-mx;
            move();
        }
        if (y+sizeY >=getHeight())
        {
          my=-my;
          move();
        }
        if (y+sizeY <=40) {
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
    public void rightMove(){
        x= x + 5;
    }
    public void leftMove(){
        x= x - 5;
    }
    public void topMove(){
        y= y - 5;
    }
    public void bottomMove(){
        y= y + 5;
    }
    public void doCompress() {
      if(sizeX > 5 && sizeY > 5) {
        sizeX = sizeX - 5;
        sizeY = sizeY - 5;
      }
    }
    public void doExtend() {
      sizeX = sizeX + 5;
      sizeY = sizeY + 5;
    }
    public void doCW() {
      gradus = gradus + Math.PI/20;
    }
    public void doCCW() {
      gradus = gradus - Math.PI/20;
    }
    public void voteCircle() {
      choice = 2;
    }
    public void voteRectangle() {
      choice = 1;
    }
}

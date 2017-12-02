package dealenx.game;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import dealenx.game.backend.Figure;


class MyCanvas extends Canvas {
    private int x, y, my, mx,sizeX,sizeY, sx,sy;
    private int xp, yp ,sxp, syp;
    public int choice;
    public double gradus;

    Figure ball;
    Figure platform;


    public MyCanvas() {
        super();
        ball = new Figure(1, 1, 50, 50);
        platform = new Figure( getHeight() - 14, 150, 300, 10);

        my = 1; //шаг или движение
        mx = 1; //шаг или движение

        sxp = 300;  //размер платформы
        syp = 10; //размер платформы
        xp = 150; //координата платформы
        yp = getHeight() - 14; //координата платформы
    }

    public void paint(Graphics g) {
        /*g.setColor(Color.orange);
        g.fillOval(x,y,sizeX,sizeY);*/

Graphics2D g2d = (Graphics2D) g.create();
        //g2d.fillRect(x,y,sizeX,sizeY);
        g.setColor(Color.orange);
        //g.fillOval(x,y,sizeX,sizeY);
        g.fillOval(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
        g.setColor(Color.black);
        g.fillRect(xp,yp, sxp, syp);
    }

    public void premove(){
        if(ball.getY() + ball.getHeight() >= yp && ball.getY() + ball.getHeight() <= yp+syp && ball.getX()+ball.getWidth() <= xp + sxp && ball.getX()+ball.getWidth() >= xp) {
            my=-my;
            move();
        }
        if (ball.getX()+ball.getWidth() <= 20||ball.getX() + ball.getWidth() >= getWidth() )
        {
            mx=-mx;
            move();
        }
        if (ball.getY() + ball.getHeight() >= getHeight())
        {
            /*my=0;
            mx=0;*/
            my=-my;
            move();
            System.out.println("You lose");
               //System.exit(0);
        }
        if (ball.getY() + ball.getHeight() <=40) {
            my=-my;
            move();
        }
        else {
            move();
        }


    }

    public void move(){
        ball.setX(ball.getX() + mx);
        ball.setY(ball.getY() + my);
    }

    public void movep (){
        addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e){
                xp = e.getX() - sxp/2;
                yp = getHeight() - 14;
            }
        });
    }

}

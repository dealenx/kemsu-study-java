package dealenx.game;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import dealenx.game.backend.Figure;


class MyCanvas extends Canvas {
    private int my, mx;

    Figure ball;
    Figure platform;

    public MyCanvas() {
        super();
        ball = new Figure(1, 1, 50, 50);
        platform = new Figure(150 ,320 - 14, 300, 10);

        my = 1; //шаг движения
        mx = 1; //шаг движения
    }

    public void paint(Graphics g) {
        g.setColor(Color.orange);
        g.fillOval(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
        g.setColor(Color.black);
        g.fillRect(platform.getX(),platform.getY(), platform.getWidth(), platform.getHeight() );
    }

    public void premove(){
        if(ball.getY() + ball.getHeight() >= platform.getY() && ball.getY() + ball.getHeight() <= platform.getY()+ platform.getHeight() && ball.getX()+ball.getWidth() <= platform.getX()  +  platform.getWidth() && ball.getX()+ball.getWidth() >= platform.getX() ) {
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
                platform.setX(e.getX() - platform.getWidth()/2);
                platform.setY(getHeight() - 14);
            }
        });
    }

}

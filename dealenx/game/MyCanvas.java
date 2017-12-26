package dealenx.game;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import dealenx.game.backend.Figure;


class MyCanvas extends Canvas {
    public MyCanvas() {
        super();
    }

    public void paint(Graphics g) {
        g.setColor(Color.orange);
        g.fillOval(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
        g.setColor(Color.black);
        g.fillRect(platform.getX(),platform.getY(), platform.getWidth(), platform.getHeight() );
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

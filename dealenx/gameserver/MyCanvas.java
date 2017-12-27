package dealenx.gameserver;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import dealenx.gameserver.backend.*;


class MyCanvas extends Canvas {
    Physic physic;

    public MyCanvas(Physic physic) {
        super();
        this.physic= physic;
    }

    public void paint(Graphics g) {
        g.setColor(Color.orange);
        g.fillOval(physic.getXBall(), physic.getYBall(), physic.getWidthBall(), physic.getHeightBall());
        g.setColor(Color.black);
        g.fillRect(physic.getXPlatform(), physic.getYPlatform(), physic.getWidthPlatform(), physic.getHeightPlatform() );
    }

    public void movep (){
        addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e){
                physic.movementPlatform(e.getX(), e.getY(), getHeight(), getHeight());
            }
        });
    }
}

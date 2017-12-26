package dealenx.game.backend;


public class Physic {
	private int my, mx;
	Figure ball;
	Figure platform;

	ball = new Figure(1, 1, 50, 50);
	platform = new Figure(150 ,320 - 14, 300, 10);

	public MyCanvas() {
			my = 1; //шаг движения
			mx = 1; //шаг движения
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
}

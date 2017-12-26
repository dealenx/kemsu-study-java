package dealenx.game.backend;


public class Physic {
	private int my, mx;
	Figure ball;
	Figure platform;
	private int height;
	private int width;



	public Physic(int width, int height) {
		ball = new Figure(1, 1, 50, 50);
		platform = new Figure(150 ,320 - 14, 300, 10);

		setWidthWindow(width);
		setHeightWindow(height);
		my = 1; //шаг движения
		mx = 1; //шаг движения
		System.out.println("created physic");
	}
	public int getWidthWindow() {
		return this.width;
	}
	public void setWidthWindow(int width) {
		this.width = width;
	}
	public int getHeightWindow() {
		return this.height;
	}
	public void setHeightWindow(int height) {
		this.height = height;
	}
	public int getWidthBall() {
		return ball.getWidth();
	}
	public void setWidthBall(int width) {
		ball.setWidth(width);
	}
	public int getHeightBall() {
		return ball.getHeight();
	}
	public void setHeightBall(int height) {
		ball.setHeight(height);
	}

	public int getWidthPlatform() {
		return platform.getWidth();
	}
	public void setWidthPlatform(int width) {
		platform.setWidth(width);
	}
	public int getHeightPlatform() {
		return platform.getHeight();
	}
	public void setHeightPlatform(int height) {
		platform.setHeight(height);
	}

	public int getXBall() {
		return ball.getX();
	}
	public void setXBall(int x) {
		ball.setX(x);
	}
	public int getYBall() {
		return ball.getY();
	}
	public void setYBall(int y) {
		ball.setY(y);
	}

	public int getXPlatform() {
		return platform.getX();
	}
	public void setXPlatform(int x) {
		platform.setX(x);
	}
	public int getYPlatform() {
		return platform.getY();
	}
	public void setYPlatform(int y) {
		platform.setY(y);
	}

	public void premove(){
			if(ball.getY() + ball.getHeight() >= platform.getY() && ball.getY() + ball.getHeight() <= platform.getY()+ platform.getHeight() && ball.getX()+ball.getWidth() <= platform.getX()  +  platform.getWidth() && ball.getX()+ball.getWidth() >= platform.getX() ) {
					my=-my;
					move();
			}
			if (ball.getX()+ball.getWidth() <= 20||ball.getX() + ball.getWidth() >= getWidthWindow() )
			{
					mx=-mx;
					move();
			}
			if (ball.getY() + ball.getHeight() >= getHeightWindow())
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

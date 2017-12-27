package dealenx.game.backend;

import java.io.*;

public class Physic implements Serializable{
	private int my, mx, myTemp, mxTemp;
	Figure ball;
	Figure platform;
	private int height;
	private int width;
	private boolean lose;



	public Physic(int width, int height) {
		ball = new Figure();
		platform = new Figure();
		setWidthWindow(width);
		setHeightWindow(height);
		setWidthBall(50);
		setHeightBall(50);
		setWidthPlatform(300);
		setHeightPlatform(10);
		init(getWidthWindow(), getHeightWindow());
	}
	private void init(int width, int height) {
		my = 1;
		mx = 1;
		setXBall(1);
		setYBall(1);
		setXPlatform(150);
		setYPlatform(width - 14);
		lose = false;
		pause();
		System.out.println("created physic");
	}
	public void pause() {
		myTemp = my;
		mxTemp = mx;
		my = 0; //шаг движения
		mx = 0; //шаг движения
		System.out.println("physic.pause()");
	}
	public void lose() {
		myTemp = 0;
		mxTemp = 0;
		my = 0; //шаг движения
		mx = 0; //шаг движения
		lose = true;
		System.out.println("physic.lose()");
		pause();
	}
	public void newGame() {
		init(getWidthWindow(), getHeightWindow());
		System.out.println("physic.newGame()");
	}
	public boolean getStatus() {
		return lose;
	}
	public void resume() {
		my = myTemp; //шаг движения
		mx = mxTemp; //шаг движения
		System.out.println("physic.resume()");
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
	public void movementPlatform(int mouseX, int mouseY, int windowWidth, int windowHeight) {
		setXPlatform(mouseX - getWidthPlatform()/2);
		setYPlatform(windowHeight - 14);

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
					lose();
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

package dealenx.game.backend;


public class Figure {

	private int width;
	private int height;

  private int x;
	private int y;

	public Figure() {
		this.width = 1;
		this.height = 1;
    this.x = 1;
    this.y = 1;
	}

	public Figure(int width, int height) {
		this.width = width;
		this.height = height;
    this.x = 1;
    this.y = 1;
	}

  public Figure(int x, int y, int width, int height ) {
		this.width = width;
		this.height = height;
    this.x = x;
    this.y = y;
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

  public int getX() {
		return this.x;
	}
	public void setX(int x) {
		this.x= x;
	}
  public int getY() {
		return this.y;
	}
	public void setY(int y) {
		this.y = y;
	}
}

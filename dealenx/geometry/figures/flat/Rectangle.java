package dealenx.geometry.figures.flat;

import dealenx.geometry.interfaces.Squareable;

public class Rectangle implements Squareable{

	private double width;
	private double length;

	public Rectangle() {
		width = 1;
		length = 1;
	}

	public Rectangle(double l_width, double l_length) {
		width = l_width;
		length = l_length;
	}

	public double getSquare() {
		return (width * length);
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double l_width) {
		width = l_width;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double l_length) {
		length = l_length;
	}
}

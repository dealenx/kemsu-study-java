package dealenx.geometry.figures.flat;

import dealenx.geometry.interfaces.Squareable;

public class Triangle implements Squareable {

	private double baseWidth;
	private double baseHeight;

	public Triangle() {
		baseWidth = 1;
		baseHeight = 1;
	}

	public Triangle(double l_baseWidth, double l_baseHeight) {
		baseWidth = l_baseWidth;
		baseHeight = l_baseHeight;
	}

	public double getSquare() {
		return (0.5 * baseWidth * baseHeight);
	}
	public double getBaseWidth() {
		return baseWidth;
	}
	public void setBaseWidth(double l_baseWidth) {
		baseWidth = l_baseWidth;
	}
	public double getBaseHeight() {
		return baseHeight;
	}
	public void setBaseWidth(double l_baseHeight) {
		baseHeight = l_baseHeight;
	}
}

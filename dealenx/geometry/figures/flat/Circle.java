package dealenx.geometry.figures.flat;

import dealenx.geometry.interfaces.Squareable;
import dealenx.geometry.exceptions.MyException;


public class Circle implements Squareable, Cloneable {

	private double radius;
	private double num;

	private void Init(double f_radius) throws MyException {
		setRadius(f_radius);
	}

	public Circle() throws MyException{
		radius = 1;
	}

	public Circle(double f_radius) throws MyException {
		Init(f_radius);
	}
	public double getSquare() {
		return (radius * radius  * 3.14);
	}
	public double getRadius() {
		return radius;
	}

	public void setRadius(double l_radius) throws MyException {

		checkNum(radius, l_radius);
		System.out.println("radius");
		System.out.println(l_radius);
	}

	public void checkNum(double l_num, double l_retu_num) throws MyException {
		System.out.println("checkNum before");
    if (l_retu_num < 0 ) {
				System.out.println("checknum if");
        MyException se = new MyException(1, "num < 0");
        throw se;
    } else {
			System.out.println("GOOD");
			System.out.println(l_retu_num);
	    l_num = l_retu_num;
		}

    }
}

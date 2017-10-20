package app;

import dealenx.geometry.interfaces.Squareable;
import dealenx.geometry.exceptions.MyException;
import dealenx.geometry.figures.flat.*;
import dealenx.geometry.figures.three_dimensional.*;

public class GeometricApp {

	public static void main(String[] args) {

		try {
			Circle circle = new Circle();
			System.out.println( "MY Circle" +  circle.getRadius() );

			Cylinder cylinder = new Cylinder(5, circle.getRadius() );
			System.out.println( " MY Cylinder.radius " +  cylinder.getRadius() + " MY Cylinder.height " +  cylinder.getHeight() );

    } catch (MyException ex) {
        System.out.println("Error code:" + ex.getErrorCode());
        System.out.println("Error message:" + ex.getMessage());
    }

	}
}

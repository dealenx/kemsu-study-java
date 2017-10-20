package dealenx.geometry.figures.three_dimensional;

import dealenx.geometry.interfaces.Volumeable;
import dealenx.geometry.figures.flat.Circle;
import dealenx.geometry.exceptions.MyException;

public class Cylinder extends Circle implements Volumeable{
  private double height;

  // Constructors
   public Cylinder() throws MyException  {
      super();
      height = 1;
   }
   public Cylinder(double l_height) throws MyException  {
      super();
      height = l_height;
   }
   public Cylinder(double l_height, double l_radius) throws MyException   {
      super(l_radius);
      height = l_height;
   }
   public double getHeight() {
      return height;
   }
   public void setHeight(double l_height) {
      height = l_height;
   }

   public double getVolume() {
      return getSquare()*height;
   }
}

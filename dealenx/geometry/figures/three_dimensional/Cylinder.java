package dealenx.geometry.figures.three_dimensional;

import dealenx.geometry.interfaces.Volumeable;
import dealenx.geometry.figures.flat.Circle;
import dealenx.geometry.exceptions.MyException;

public class Cylinder extends Circle implements Volumeable{
  private double height;

  protected void Init(double f_radius,double f_height ) throws MyException {
    /*
    super.Init(f_radius);
    setHeight(f_height);
    */
    setRadius(f_radius);
    setHeight(f_height);
	}

  // Constructors
   public Cylinder() throws MyException  {
      super();
      setHeight(1);
   }
   public Cylinder(double l_height) throws MyException  {
      super();
      setHeight(l_height);
   }
   public Cylinder(double l_height, double l_radius) throws MyException  {

      //super(l_radius); //Не присваивается radius
      Init(l_radius);
      height = l_height;
   }
   public double getHeight() {
      return height;
   }
   public void setHeight(double l_height) throws MyException {
      checkNum(height, l_height);
   }

   public double getVolume() {
      return getSquare()*height;
   }
}

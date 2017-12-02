package app;

import java.io.*;
import app.example.*;

public class InByteApp {
   public static void main(String[] args) throws Exception, IOException{
	    File f= new File("./data/Temp.dat");
      Owner owner;
      Child c;

      ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
      owner=(Owner)in.readObject();
      c = owner.c;
      System.out.println("Owner.b: " +owner.b + " Child.a: "+c.a);
      in.close();
   }
}

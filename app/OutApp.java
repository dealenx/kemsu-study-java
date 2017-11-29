package app;

import java.io.*;

public class OutApp {

  public static void main(String[] args) {
    /*
    String s = "Привет";
    byte[] b = s.getBytes();
    System.out.println(b.length);

    try {
      OutputStream out = new FileOutputStream("Temp.txt");
      for (int i = 0; i < b.length; i++) {
        out.write((int) b[i]);
      }
      out.close();
    } catch(IOException x) {
       System.err.format("IOException: %s%n", x);
    }
	}*/

  Child c = new Child();
  c.a = 100;
  Owner owner = new Owner();
  owner.b = 200;
  owner.c = c;
  Object objSave = owner;

  try {
    OutputStream out = new FileOutputStream("Temp.dat");
    ObjectOutputStream oos = new ObjectOutputStream(out);
    oos.writeObject(objSave);
    out.close();
  } catch(IOException x) {
     System.err.format("IOException: %s%n", x);
  }
}
}

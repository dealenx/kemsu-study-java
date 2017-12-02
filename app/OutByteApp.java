package app;

import java.io.*;
import app.example.*;

public class OutByteApp {

  public static void main(String[] args) throws Exception, IOException {

    Child c = new Child();
    c.a = 100;
    Owner owner = new Owner();
    owner.b = 200;
    owner.c = c;
    Object objSave = owner;

    File f= new File("./data/Temp.dat");
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
    out.writeObject(objSave);
    out.close();
  }
}

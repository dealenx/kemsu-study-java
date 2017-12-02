package app;

import java.io.*;

public class OutApp {

  public static void main(String[] args) {

    String s = "Привет";
    byte[] b = s.getBytes();
    System.out.println(b.length);

    try {
      OutputStream out = new FileOutputStream("./data/Temp.txt");
      for (int i = 0; i < b.length; i++) {
        out.write((int) b[i]);
      }
      out.close();
    } catch(IOException x) {
       System.err.format("IOException: %s%n", x);
    }
	}
}

package app;

import java.io.*;

public class InApp {

	public static void main(String[] args) {
    InputStream in = new FileInputStream("./data/Temp.txt");
    int count = in.available();
    Byte[] b = new Byte[count];
    try {
      int i = 0;
      while(true) {
        int res = in.read();
        if(res == -1) {break;}
        else {b[i] = (byte) res; i++;}
      }
      //String s = new String(b);
      in.close();
    } catch(IOException x) {
       System.err.format("IOException: %s%n", x);
    }
	}
}

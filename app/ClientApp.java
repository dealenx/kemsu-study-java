package app;

import java.io.*;
import java.net.*;

class ClientApp {
	public static void main(String args[]) {
		try {
		Socket s=new Socket ("127.0.0.1",1111);
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();

		out.write(1); in.close(); out.close(); s.close();
		} catch (IOException ex) {
			System.out.println("Error");
		}
	}
}

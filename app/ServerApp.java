package app;

import java.io.*;
import java.net.*;

class ServerApp
{
public static void main(String args[])
{
try {
ServerSocket ss= new ServerSocket (1111);
System.out.println("Listening");
Socket s= ss.accept();
System.out.println("Accepted");

InputStream in = s.
getInputStream ();

OutputStream out = s.
getOutputStream ();

int a=in.read();
System.out.println(a);
out.write(1); in.close(); out.close(); s.close(); ss.close();
} catch (IOException ex) {
	System.out.println(1);
}
}
}

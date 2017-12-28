package app;
import java.io.IOException;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import dealenx.gameserver.*;

public class ClientGameApp {
	private Socket socket = null;
	private ObjectInputStream inputStream = null;
	private ObjectOutputStream outputStream = null;
	private boolean isConnected = false;

	public ClientGameApp() {

	}

	public void communicate() {

		while (!isConnected) {
			try {
				socket = new Socket("localHost", 4445);
				System.out.println("Connected");
				isConnected = true;

				inputStream = new ObjectInputStream(socket.getInputStream());

				Message message = (Message) inputStream.readObject();


				System.out.println("Object received = " + message);

			} catch (SocketException se) {
				se.printStackTrace();
			// System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException cn) {
				cn.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ClientGameApp client = new ClientGameApp();
		client.communicate();
	}
}

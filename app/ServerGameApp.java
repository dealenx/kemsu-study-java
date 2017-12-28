package app;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import dealenx.gameserver.*;
	public class ServerGameApp {
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	private ObjectInputStream inputStream = null;
	private ObjectOutputStream outputStream = null;

	public ServerGameApp() {

	}

	public void communicate() {
		try {
			serverSocket = new ServerSocket(4445);
			socket = serverSocket.accept();
			System.out.println("Connected");
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			Message message = new Message(1, "Bijoy");
			/*System.out.println("Object to be written = " + message);*/
			outputStream.writeObject(message);

			socket.close();

		} catch (SocketException se) {
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		} /*catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		}*/
	}

		public static void main(String[] args) {
			ServerGameApp server = new ServerGameApp();
			server.communicate();
		}
}

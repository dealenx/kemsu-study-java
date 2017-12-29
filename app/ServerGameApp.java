package app;

import java.sql.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import dealenx.gameserver.*;
import dealenx.gameserver.backend.*;

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

			int x_mes;
			int y_mes;
			String name_mes;
			Physic message2 = new Physic(1000,  600);

			DriverManager.registerDriver(new org.postgresql.Driver());
            //Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/test";
            String login = "postgres";
            String password = "123";
			System.out.println("Getting connection...");
            Connection con = DriverManager.getConnection(url, login, password);
			System.out.println("OK");
            try {
                Statement stmt = con.createStatement();
				//ResultSet rs = stmt.executeQuery("SELECT * FROM pg_class");
				ResultSet rs = stmt.executeQuery("SELECT * FROM \"game\" where id = 1");
                while (rs.next()) {
                    //String str = rs.getString("relname") + " " + rs.getString("reltype");
						message2.setXBall(Integer.parseInt(rs.getString("x")));
						message2.setYBall(Integer.parseInt(rs.getString("y")));
                }

								outputStream.writeObject(message2);

                rs.close();
                stmt.close();
								socket.close();
            } finally {
                con.close();
            }

		} catch (SocketException se) {
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e){
      e.printStackTrace();
    }
	}

		public static void main(String[] args) {
			ServerGameApp server = new ServerGameApp();
			server.communicate();
		}
}

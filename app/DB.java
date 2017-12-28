package app;

import java.sql.*;

class DB
{
	public static void main(String args[])
	{
		System.out.println("Testing DB...");

		try
		{
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
				ResultSet rs = stmt.executeQuery("SELECT * FROM \"students\" where id = 1");
                while (rs.next()) {
                    //String str = rs.getString("relname") + " " + rs.getString("reltype");
					String str = rs.getString("id") + " " + rs.getString("name");
                    System.out.println(str);
                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        }
		catch (Exception e)
		{
            e.printStackTrace();
        }
	}
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseService {

	public static Connection getConnect()
	{
		Connection con=null;
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/Library_Management";
		String username="root";
		String password="015909";
		con=DriverManager.getConnection(url, username, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
	}
}

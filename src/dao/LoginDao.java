package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao 
{
   public String doLogin(Connection conn,String username,String password)
   {
	   String query="select * from login where user_name=? and password=?";
	   try
	   {
		   PreparedStatement ps=conn.prepareStatement(query);
		   ps.setString(1, username);
		   ps.setString(2, password);
		   ResultSet rs=ps.executeQuery();
		   if(rs.next())
		   {
			   return rs.getString("user_type");
		   }
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	return null;
   }
}

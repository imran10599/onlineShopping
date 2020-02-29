package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {
	
	public boolean validate(String uname,String pass)
	{
		
		try {
		Connection con =DriverConnection.getConnection();
		
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery("select *from userdetails where unmae=\'"+uname+"\'and pass=\'"+pass+"\'");
		
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

}

package test;

import java.sql.*;

public class DriverConnection {

	public  static  Connection Connection()  throws Exception{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		return DriverManager.getConnection("jdbc:oracle:thin@localhost:8080:xe","system","manager");
		
	}

	public static java.sql.Connection getConnection1() {
		// TODO Auto-generated method stub
		return null;
	}

	public static java.sql.Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}

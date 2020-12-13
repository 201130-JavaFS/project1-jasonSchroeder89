package com.revature.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException {
	
	try {
		Class.forName("org.postgresql.Driver");
	} 
	
	catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=ers";
	String username = "postgres";
	String password = "postgres"; 
	
	return DriverManager.getConnection(url, username, password);
	}
}

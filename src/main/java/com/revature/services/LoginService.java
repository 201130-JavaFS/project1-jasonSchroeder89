package com.revature.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.data.ConnectionUtil;

public class LoginService {

	public boolean login(String username, String password) {
		
		String hashedPass = hashPassword(password);
		
		try {
			
			Connection conn= ConnectionUtil.getConnection();
			String sql = "select username, password from \"Users\" where "
					+ "username = ? and password = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, username);
			statement.setString(2,  hashedPass);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				return true;
			}			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		//if no result will return null
		return false;
	}
	
	private String hashPassword(String password) {
		StringBuilder hash = new StringBuilder();
		
		/*
		 * TODO implement better encryption, for now reverse string
		 */
		
		for (int i = password.length() - 1; i >= 0; i--) {
			hash.append(password.charAt(i));
		}
		
		String hashPass = new String(hash);
		
		return hashPass;
	}	
}

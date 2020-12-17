package com.revature.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.LoginDTO;

public class LoginDAOImp implements LoginDAO {

	@Override
	public boolean login(LoginDTO dto) {
		try {
			
			Connection conn= ConnectionUtil.getConnection();
			String sql = "select user_id, role_id from \"Users\" where "
					+ "username=? and \"password\" = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, dto.getUsername());
			statement.setString(2, dto.getPassword());
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				dto.setId(result.getInt(1));
				dto.setRole(result.getInt(2));
				return true;
			}			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		//if no result will return null
		return false;
	}
}

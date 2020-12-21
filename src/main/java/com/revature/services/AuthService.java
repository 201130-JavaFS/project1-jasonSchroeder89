package com.revature.services;

import com.revature.data.LoginDAO;
import com.revature.data.LoginDAOImp;
import com.revature.models.User;
import com.revature.util.Encryptor;

public class AuthService {

	public User login(User user) {
		
		user.setPassword(Encryptor.hashPassword(user.getPassword()));
		LoginDAO loginDAO = new LoginDAOImp();
		
		return loginDAO.login(user);
	}
}

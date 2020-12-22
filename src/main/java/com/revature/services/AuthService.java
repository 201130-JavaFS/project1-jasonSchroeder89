package com.revature.services;

import com.revature.data.LoginDAO;
import com.revature.data.LoginDAOImp;
import com.revature.models.User;
import com.revature.util.EncryptorUtil;

public class AuthService {

	public User login(User user) {
		
		user.setPassword(EncryptorUtil.hashPassword(user.getPassword()));
		LoginDAO loginDAO = new LoginDAOImp();
		
		User validUser = loginDAO.login(user);
		
		System.out.println(validUser);
		
		return validUser;
	}
}

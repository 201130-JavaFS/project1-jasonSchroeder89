package com.revature.services;

import com.revature.data.LoginDAO;
import com.revature.data.LoginDAOImp;
import com.revature.models.LoginDTO;
import com.revature.util.Encryptor;

public class AuthService {

	public boolean login(LoginDTO dto) {
		
		dto.setPassword(Encryptor.hashPassword(dto.getPassword()));
		LoginDAO loginDAO = new LoginDAOImp();
		
		return loginDAO.login(dto);
	}
}

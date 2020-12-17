package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.LoginDTO;
import com.revature.services.AuthService;

public class AuthController {

	private ObjectMapper mapper = new ObjectMapper();
	private AuthService loginService = new AuthService();
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws 
		IOException {
		
		if (req.getMethod().equals("POST")) {
			BufferedReader reader = req.getReader();
			
			StringBuilder sb = new StringBuilder();
			
			String line = reader.readLine();
			
			while(line != null) {
				sb.append(line);
				
				line = reader.readLine();
			}
			
			String body = new String(sb);
			
			LoginDTO loginDTO = mapper.readValue(body, LoginDTO.class);
			
			if (loginService.login(loginDTO)) {
				
				int[] ids = {loginDTO.getId(), loginDTO.getRole()};
				
				String json = mapper.writeValueAsString(ids);
				
				res.getWriter().print(json);
				
				HttpSession session = req.getSession();
				
				session.setAttribute("loggedIn", true);
				
				res.setStatus(200);
			}
			
			else {
				HttpSession session = req.getSession(false);
				
				if (session != null) {
					session.invalidate();
				}
				
				res.setStatus(401);
				
				res.getWriter().print("Login Failed");
			}
		}
	}

	public void logout(HttpServletRequest req, HttpServletResponse res) 
			throws IOException {
		
		if (req.getMethod().equals("PUT")) {
			req.getSession().invalidate();
			
			res.setStatus(200);
			
			res.getWriter().print("Logout Successful");
		}
	}
}

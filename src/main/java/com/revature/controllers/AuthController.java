package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.web.MasterServlet;

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
			
			User user = mapper.readValue(body, User.class);
			
			User validUser = loginService.login(user);
			
			if (validUser == null) {
				HttpSession session = req.getSession(false);
				
				if (session != null) {
					session.invalidate();
				}
				
				res.setStatus(401);
				
				res.getWriter().print("Login Failed");
			}
			
			else {
				if (validUser.getUsername().equals(user.getUsername())) {
					String json = mapper.writeValueAsString(validUser);
					
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
	}

	public void logout(HttpServletRequest req, HttpServletResponse res) 
			throws IOException {
		
		if (req.getMethod().equals("PUT")) {
			
			req.getSession().invalidate();
			
			res.setStatus(200);
		}
	}
}

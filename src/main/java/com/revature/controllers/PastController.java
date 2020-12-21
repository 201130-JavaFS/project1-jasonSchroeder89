package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.PastService;

public class PastController {
	
	private ObjectMapper mapper = new ObjectMapper();
	private PastService pastService = new PastService();
	
	public void getPastRequests(HttpServletRequest req, 
			HttpServletResponse res) throws IOException {
		
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
			
			List<Reimbursement> requests = pastService.getRequests(user);
			
			String json = mapper.writeValueAsString(requests);
			
			res.getWriter().print(json);
			
			res.setStatus(200);
		}	
	}	
}

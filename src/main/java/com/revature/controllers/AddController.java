package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.AddService;

public class AddController {
	
	private ObjectMapper mapper = new ObjectMapper();
	private AddService addService = new AddService();

	public void addRequest(HttpServletRequest req, HttpServletResponse res) 
			throws IOException {
		
		if (req.getMethod().equals("POST")) {
			BufferedReader reader = req.getReader();
			
			StringBuilder sb = new StringBuilder();
			
			String line = reader.readLine();
			
			while(line != null) {
				sb.append(line);
				
				line = reader.readLine();
			}
			
			String body = new String(sb);			
			
			Reimbursement reimbursement = mapper.readValue(body, 
					Reimbursement.class);
			
			if (addService.addRequest(reimbursement)) {
				
				res.getWriter().print("Request submitted");
				
				res.setStatus(200);
			}
			
			else {
				res.getWriter().print("Add Request Failed");
				
				res.setStatus(500);
			}
		}		
	}	
}
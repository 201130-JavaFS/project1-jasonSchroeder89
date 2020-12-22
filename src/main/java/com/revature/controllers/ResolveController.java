package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ResolveService;

public class ResolveController {
	
	private ObjectMapper mapper = new ObjectMapper();
	private ResolveService resolveService = new ResolveService();
	
	public void resolveRequest(HttpServletRequest req, HttpServletResponse res) 
			throws IOException {
		
		if (req.getMethod().equals("PUT")) {
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
			
			System.out.println(reimbursement.getResolver());
			System.out.println(reimbursement.getTime_resolved());
			
			if (resolveService.resolve(reimbursement)) {
				res.getWriter().print("Request resolved");
				
				res.setStatus(200);
			}
			
			else {
				res.getWriter().print("Resolve Request Failed");
				
				res.setStatus(500);			
			}
		}
		
	}
}

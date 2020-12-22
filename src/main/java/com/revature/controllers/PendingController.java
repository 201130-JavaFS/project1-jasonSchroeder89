package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.PendingService;

public class PendingController {

	private PendingService pendingService = new PendingService();
	private ObjectMapper om = new ObjectMapper();
	
	public void getPending(HttpServletResponse res) throws IOException {
		
		List<Reimbursement> pending = pendingService.getPending();
		String json = om.writeValueAsString(pending);
		res.getWriter().print(json);
		res.setStatus(200);
	}

}

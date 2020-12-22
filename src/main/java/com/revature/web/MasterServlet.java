package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controllers.AddController;
import com.revature.controllers.AuthController;
import com.revature.controllers.PastController;
import com.revature.controllers.PendingController;
import com.revature.controllers.ResolveController;

public class MasterServlet extends HttpServlet {
	
	private final AuthController authController = new AuthController();
	private final AddController addController = new AddController();
	private final PastController pastController = new PastController();
	private final PendingController pendingController = new PendingController();
	private final ResolveController resolveController = new ResolveController();
	
	static final Logger logger = LogManager.getLogger(
			MasterServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		
		res.setContentType("application/json");
		
		res.setStatus(404);
		
		final String URI = req.getRequestURI().replace("/project-1/", "");
		
		switch (URI) {
		case "login":
			logger.info("Login request made");
			authController.login(req, res);
			break;
			
		case "add":
			logger.info("New reimbursement requested");
			addController.addRequest(req, res);
			break;
			
		case "pending":
			logger.info("Request made for pending reimbursements");
			pendingController.getPending(res);
			break;
			
		case "resolve":
			logger.info("Reimbursement request resolved");
			resolveController.resolveRequest(req, res);
			break;
			
		case "past":
			logger.info("Request for reimbursement history made");
			pastController.getPastRequests(req, res);
			break;
			
		case "logout":
			logger.info("User logged out of system");
			authController.logout(req, res);
			break;
			
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		doGet(req, res);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		doGet(req, res);
	}
}
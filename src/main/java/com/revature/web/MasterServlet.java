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
	
	private static final Logger logger = LogManager.getLogger(
			MasterServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		
		logger.info("GET request received");
		logger.error("Test");
		res.setContentType("application/json");
		
		res.setStatus(404);
		
		final String URI = req.getRequestURI().replace("/project-1/", "");
		
		switch (URI) {
		case "login":
			authController.login(req, res);
			break;
			
		case "add":
			addController.addRequest(req, res);
			break;
			
		case "pending":
			pendingController.getPending(res);
			break;
			
		case "resolve":
			resolveController.resolveRequest(req, res);
			break;
			
		case "past":
			pastController.getPastRequests(req, res);
			break;
			
		case "logout":
			authController.logout(req, res);
			break;
			
		default:
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		logger.info("POST request received");
		doGet(req, res);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		logger.info("PUT request receveived");
		doGet(req, res);
	}
}
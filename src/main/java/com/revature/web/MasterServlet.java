package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.AddController;
import com.revature.controllers.AuthController;
import com.revature.controllers.PastController;

public class MasterServlet extends HttpServlet {
	
	private final AuthController authController = new AuthController();
	private final AddController addController = new AddController();
	private final PastController pastController = new PastController();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		res.setContentType("application/json");
		// By default tomcat will send back a successful status code if it finds a
		// servlet method.
		// Because all requests will hit this method, we are defaulting to not found and
		// will override for success requests.
		res.setStatus(404);
		
		final String URI = req.getRequestURI().replace("/project-1/", "");
		
		switch (URI) {
		case "login":
			authController.login(req, res);
			break;
			
		case "add":
			addController.addRequest(req, res);
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
		
		doGet(req, res);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		doGet(req, res);
	}
}
package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		
		String username = req.getParameter("userId");
		String password = req.getParameter("password");
		
		RequestDispatcher rd = null;
		PrintWriter pw = res.getWriter();
		
		//The following should be in service layer to validate user credentials
		//by hitting database
		if (username.equals("revAssoc") && (password.equals("password"))) {
			
			//When getting the RequestDispatcher, you can state the relative
			//path I want to forward as a String param.
			rd = req.getRequestDispatcher("success");
			rd.forward(req, res);			
		}
		
		else {
			rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
			pw.print("<span style='color:red; text-align:center'>Invalid "
					+ "Username and/or Password</span>");
		}
	}
}
// Servlet to check whether the teacher logging in has provided the correct credentials or not
// if incorrect display an "Please RETRY" message
// else redirect to the page from where he can see or group the students

package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String i = req.getParameter("username");
		String j = req.getParameter("password");
	
		PrintWriter out = res.getWriter();
		
		if(i.equals("teacher") && j.equals("password"))
		{
			RequestDispatcher view = req.getRequestDispatcher("/teacher.html");
			view.forward(req, res);
		}
		else {
			out.println("please retry");
		}
	}

}

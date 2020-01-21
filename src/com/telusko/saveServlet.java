// this servlet parses the values from the frontend
// calculates the average from skill points
// then saves the values to the database

package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.*; 

public class saveServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String name = req.getParameter("name");
		int regdno = Integer.parseInt(req.getParameter("regdno"));
		
		int html = Integer.parseInt(req.getParameter("html"));
		int java = Integer.parseInt(req.getParameter("java"));
		int js = Integer.parseInt(req.getParameter("js"));
		
		int managerial = Integer.parseInt(req.getParameter("managerial"));
		int leadership = Integer.parseInt(req.getParameter("leadership"));
		int cooperation = Integer.parseInt(req.getParameter("cooperation"));
		
		double average = (html+java+js+managerial+leadership+cooperation)/6.0;
		
		PrintWriter out = res.getWriter();
		
		try{ 
			// CONNECT WITH THE DATABSE using the provided url
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
			
			// check if the schema and tables are present, else create those
			PreparedStatement ps1 = con.prepareStatement("CREATE SCHEMA IF NOT EXISTS student_grouping;");
			ps1.executeUpdate();
			PreparedStatement ps2 = con.prepareStatement("USE student_grouping;");
			ps2.executeUpdate();
			PreparedStatement ps3 = con.prepareStatement("CREATE TABLE IF NOT EXISTS student_info (sname varchar(20), regdno integer primary key, html integer, java integer, js integer, managerial integer, leadership integer, cooperation integer, average double);");
			ps3.executeUpdate();
		      
			PreparedStatement ps=con.prepareStatement(  
			"INSERT INTO student_info (sname,regdno,html,java,js,managerial,leadership,cooperation,average) VALUES (?,?,?,?,?,?,?,?,?);");  
			ps.setString(1,name);  
			ps.setInt(2,regdno);
			ps.setInt(3,html);
			ps.setInt(4,java);
			ps.setInt(5,js);  
			ps.setInt(6,managerial);
			ps.setInt(7,leadership);
			ps.setInt(8,cooperation);
			ps.setDouble(9,average);
			ps.executeUpdate();
			
			RequestDispatcher view = req.getRequestDispatcher("/index.html");
			view.forward(req, res);         
		}
		catch(Exception e){
			System.out.println(e);
			out.println("Error during uploading, please try again later");
		}
	}
}

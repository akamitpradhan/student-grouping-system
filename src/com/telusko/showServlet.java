// this servlet extracts the values of skills of students from the database
// then redirects to another jsp to display the details of the students

package com.telusko;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		
		int length=0;
		String[] students = new String[100];
		ArrayList<Integer> regd=new ArrayList<Integer>();
		ArrayList<Integer> html=new ArrayList<Integer>();
		ArrayList<Integer> java=new ArrayList<Integer>();
		ArrayList<Integer> js=new ArrayList<Integer>();
		ArrayList<Integer> managerial=new ArrayList<Integer>();
		ArrayList<Integer> leadership=new ArrayList<Integer>();
		ArrayList<Integer> cooperation=new ArrayList<Integer>();

		//fetch data and store from the db
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
			"select * from student_info;");     
			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				students[length]=rs.getString(1);
				regd.add(rs.getInt(2));
				html.add(rs.getInt(3));
				java.add(rs.getInt(4));
				js.add(rs.getInt(5));
				managerial.add(rs.getInt(6));
				leadership.add(rs.getInt(7));
				cooperation.add(rs.getInt(8));
				length++;
			}   
		}
		catch(Exception e){
			System.out.println(e);
			out.println("Error during uploading, please try again later");
		}
	
		req.setAttribute("students", students);
		req.setAttribute("regd", regd);
		req.setAttribute("html", html);
		req.setAttribute("java", java);
		req.setAttribute("js", js);
		req.setAttribute("managerial", managerial);
		req.setAttribute("leadership", leadership);
		req.setAttribute("cooperation", cooperation);
		
		RequestDispatcher RequetsDispatcherObj =req.getRequestDispatcher("/show.jsp");
		RequetsDispatcherObj.forward(req, res);	
	}
}

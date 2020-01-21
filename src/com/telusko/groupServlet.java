// this servlet extracts values from the database
// compares and form groups using Z-Ladder Algorithm
// redirect the memebers to another jsp to display it

package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class groupServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		
		int length=0;
		String[] students = new String[100];
		double[] avg = new double[100];
		
		
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
				avg[length]=rs.getDouble(9);
				length++;
			}   
		}
		catch(Exception e){
			System.out.println(e);
			out.println("Error during uploading, please try again later");
		}

		//Z-ladder algorithm
		int i,j;
		int size=length;
		double temp;
		String temp1;
		int grpno;
		grpno=(length+2)/3;
		
		String[][] grp=new String[grpno][3];
		
		for(i=0;i<size-1;i++)
		{
			for(j=0;j<size-1-i;j++)
			{
				if(avg[j]<avg[j+1])
				{
					temp=avg[j];
					avg[j]=avg[j+1];
					avg[j+1]=temp;
					
					temp1=students[j];
					students[j]=students[j+1];
					students[j+1]=temp1;
				}
			}
		}
		for(i=0;i<size;i++)
		{
			
			System.out.println(avg[i]);
			System.out.println(students[i]);
		}
		
		System.out.println("\n\n\n\n\n\n");
		
		int row,x,y;
		int ctr,m,n=0;
		ctr=1;
		for(i=0;i<length;i++)
		{
			if(i%grpno==0&&i!=0)
			{
				ctr=(-1)*ctr;
				n=n+1;
			}
			if(ctr==1)
			{
				m=i%grpno;
			}
			else
			{
				m=grpno-(i%grpno)-1;
			}
			
			grp[m][n]=students[i];
			
		}
		for(i=0;i<grpno;i++)
		{
			for(j=0;j<3;j++)
			{
				System.out.println(grp[i][j]);
			}
			System.out.println("\n");
		}
		
		req.setAttribute("grp", grp);
		req.setAttribute("grpno", grpno);
		
		RequestDispatcher RequetsDispatcherObj =req.getRequestDispatcher("/groups.jsp");
		RequetsDispatcherObj.forward(req, res);
	}
}

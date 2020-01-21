<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.ArrayList" %>    

<% String[] students = (String[])request.getAttribute("students"); %>
<% ArrayList regd = (ArrayList)request.getAttribute("regd"); %>
<% ArrayList html = (ArrayList)request.getAttribute("html"); %>
<% ArrayList java = (ArrayList)request.getAttribute("java"); %>
<% ArrayList js = (ArrayList)request.getAttribute("js"); %>
<% ArrayList managerial = (ArrayList)request.getAttribute("managerial"); %>
<% ArrayList cooperation = (ArrayList)request.getAttribute("cooperation"); %>
<% ArrayList leadership = (ArrayList)request.getAttribute("leadership"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
	<title>Student Details</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="/stylesheets/main.css"></head>
	<style>
		thead td{
			font-weight: bold;
		}
		td{
			text-align: center;
		}
	</style>
<body>

	<div style="display: flex; justify-content: center;">
		<h1>Student Details</h1>
	</div>
	
	<div class="container">
		<table class="table table-bordered table-dark">
			<thead class="thead-dark">
				<tr>
					<td rowspan="2" scope="col">Student Name</td>
					<td rowspan="2" scope="col">Registration no.</td>
					<td colspan="3">Technical Skills</td>
					<td colspan="3">Soft Skills</td>
				</tr>
				<tr>
					<td scope="col">HTML</td>
					<td scope="col">JAVA</td>
					<td scope="col">JS</td>
					<td scope="col">Managerial</td>
					<td scope="col">Leadership</td>
					<td scope="col">Cooperation</td>
				</tr>
			</thead>
			<% for(int i=0;i<html.size();i++){ %>
				<tr>
						<td><%= students[i] %></td>
						<td><%= regd.get(i) %></td>
						<td><%= html.get(i) %></td>
						<td><%= java.get(i) %></td>
						<td><%= js.get(i) %></td>
						<td><%= managerial.get(i) %></td>
						<td><%= leadership.get(i) %></td>
						<td><%= cooperation.get(i) %></td>
				</tr>
			<% } %>
		</table>
	</div>
	
	
	<!--Required scripts CDNs-->
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>
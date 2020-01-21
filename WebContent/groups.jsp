<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% String[][] grp = (String[][])request.getAttribute("grp"); %>
<% int grpno = (Integer)request.getAttribute("grpno"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Groups</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="/stylesheets/main.css">
	<style>
		thead td{
			font-weight: bold;
		}
		td{
			text-align: center;
		}
	</style>
</head>

<body>

	<div style="display: flex; justify-content: center;">
		<h1>Groups</h1>
	</div>
	
	<div class="container">
		<table class="table table-bordered table-dark">
			<thead class="thead-dark">
				<tr>
					<td scope="col">Group No.</td>
					<td scope="col">Member 1</td>
					<td scope="col">Member 2</td>
					<td scope="col">Member 3</td>
				</tr>
			</thead>
			<%for(int i=0;i<grpno;i++)
			{%>
				<tr>
				<td scope="row"><%= i+1 %></td>
				<% for(int j=0;j<3;j++){ %>
					<% if (grp[i][j]==null){ %>
						<td>-</td>
					<% } else{ %>
						<td><%=grp[i][j]%></td>
					<% } %>
				<% } %>
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
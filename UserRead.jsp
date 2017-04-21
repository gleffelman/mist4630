<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<%
   
	String table = (String) request.getAttribute("table");   

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Fake News Database</title>
</head>
<body>

<h1>Fake News Database</h1>
	<br>
	<br>
	<div id="table">
	<%= table %>
	</div>
	<br>
	<br>
	<div id="GuestLinks">
	<a href = "UserAddServlet">Click to Add User</a>
	<br>
	<a href="AdminHome.jsp">Click to Return Home</a>
	</div>
	<p id = "footer">Created by Garrett Leffelman and Kirk Bailey (2017)</p>

</body>
</html>
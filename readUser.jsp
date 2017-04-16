<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
   
	String table = (String) request.getAttribute("table");   

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grocery Database</title>
</head>
<body>

<h1>Grocery Database</h1>

<%= table %>
<br />
<a href = "add">Add a product</a>

</body>
</html>
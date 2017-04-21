<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="models.User"; %>

<% User user = (User) request.getAttribute("user"); %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fake News Database - Update a User</title>
</head>
<body>

<h1>Fake News Database - Update a User</h1>

<form name=UpdateUser action=updateUser method=get ></form>

<label>
	User Email:
</label>
<input type = text name = email value="<%=user.getEmail()%>"/>
<br/>

<label>
	User Password:
</label>
<input type = text name=upwd value="<%=user.getUpwd()%>"/>
<br/>


<input type = submit name=submit value="Update the User"/>;


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error: Invalid Input</title>
</head>
<body>

<p> One or more of the values that you have entered is invalid for the given field. Please ensure that all names
or text-based fields (description, author etc.) are entered as alphabetical strings of characters, and that all numeric
values (validity rating, date etc.) are entered as numbers. The field of particular conflict might be the date field.
While many individuals format their dates with special characters such as "-" or "/", the date field in our database
is formatted to accept dates solely as numeric values. For example, April 24th, 2017 would be entered into our database
as "170424" with the first two characters representing the year, the second two the month, and the last two the day. 
Please keep this in mind as you continue working with our fakenews database.
</p>

</body>
</html>
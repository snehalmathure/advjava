<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>logout</title>
</head>
<body>

	<h2>Thank you...</h2>
	<% session.invalidate();%>
	<p> you are Successfully Logged out..</p>
	<p>
	<a href="index.jsp">back to Login</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>new user</title>
</head>
<body>

	<form method="post" action="register.jsp">
	Firstname:<input type="text" name="fname"/><br/><br/>
	Lastname:<input type="text" name="lname"/><br/><br/>
	Email:<input type="text" name="email"/><br/><br/>
	password:<input type="password" name="password"/><br/><br/>
	DOB:<input type="date" name="date"/><br/><br/>
	
	<input type="submit" value="Register">
	<a href="index.jsp">SignIn</a>
	
	
</form>

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>

	<jsp:useBean id="reg" class="com.sunbeam.jspBeans.RegisterBean" scope="session"/>
	<jsp:setProperty name="reg" property="fname"/>
	<jsp:setProperty name="reg" property="lname"/>
	<jsp:setProperty name="reg" property="email"/>
	<jsp:setProperty name="reg" property="password"/>
	<jsp:setProperty name="reg" property="date"/>
	
	${reg.registerUser()}
	
	<c:choose>
	<c:when test="${ reg.count == 1}">
		
		<h3>Registered Successfully</h3>
		<a href="index.jsp">Back To Login</a>
		
		
	</c:when>
	
	<c:otherwise>
		<h3>Registration Failed</h3>
	</c:otherwise>
	
	
</c:choose>
	
	

</body>
</html>
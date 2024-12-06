<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="lg" class="com.sunbeam.jspBeans.login" scope="session"/>
<jsp:setProperty name="lg" property="*"/>

${lg.login()}

<c:choose>
	<c:when test="${lg.user != null}">
		
		<c:choose>
		
			<c:when test="${lg.user.role == 'admin' }">
				<c:redirect url="result.jsp"/>
			</c:when>
			<c:otherwise>
				<c:redirect url="candidateList.jsp"/>
			</c:otherwise>

		</c:choose>
		
		
	</c:when>
	
	<c:otherwise>
		<h3>Login Failed</h3>
		<p>
			Invalid email or password.
			</p>
			<p>
			<a href="index.jsp">Login Again</a>
			</p>
	</c:otherwise>
	
	
</c:choose>
	





</body>
</html>
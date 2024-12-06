<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote</title>
</head>
<body>

<jsp:useBean id="vb" class="com.sunbeam.jspBeans.VoteBeans"/>
<jsp:setProperty property="candId" name="vb" param="candidate"/>
<jsp:setProperty property="userId" name="vb" value="${lg.user.id}"/>

<c:choose>
	<c:when test="${lg.user.status == 0}">
	${vb.vote()}
	<c:choose>
		<c:when test="${vb.success}">
			<p>your Vote is casted successfully..</p>
			${lg.user.setStatus(1)}
		</c:when>
	
	</c:choose>
		
	</c:when>
	
	<c:otherwise>
		<p>you have already voted...</p>
	</c:otherwise>
</c:choose>
	
<p>

	<a href="logout.jsp">logout</a>
</p>
	
</body>
</html>
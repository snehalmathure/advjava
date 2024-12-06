<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update</title>
</head>
<body>

	<jsp:useBean id="ucb" class="com.sunbeam.jspBeans.updateCandBean"/>
	<jsp:setProperty property="*" name="ucb"/>
	
	${ucb.updateCand()}
	
	<c:choose>
	
		<c:when test="${ucb.count == 1}">
			
			<jsp:forward page="result.jsp">
				<jsp:param value="Updated Candidate" name="msg"/>
			</jsp:forward>
		<c:otherwise>
				<jsp:forward page="result.jsp">
				<jsp:param value="candidate update failed" name="msg"/>
				</jsp:forward>
			
		</c:otherwise>
		
		</c:when>
	
	</c:choose>
	
	
	
	
</body>
</html>
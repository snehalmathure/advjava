<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register candidate</title>
</head>
<body>
	<jsp:useBean id="rcb" class="com.sunbeam.jspBeans.registerCandidateBean"/>
	<jsp:setProperty name="rcb" property="*"/>
	
	${rcb.addCandidate()}
	
<c:choose>
	<c:when test="${ rcb.count == 1}">
		
		<jsp:forward page="result.jsp">
			<jsp:param name="addmsg" value="Candidate added"/>
			
		</jsp:forward>
		
		
	</c:when>
	
	<c:otherwise>
			<jsp:forward page="result.jsp">
			<jsp:param name="addmsg" value="Candidate add failed"/>
			
		</jsp:forward>
	</c:otherwise>
	
	
</c:choose>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>find candidate to Delete</title>
</head>
<body>
	<jsp:useBean id="db" class="com.sunbeam.jspBeans.deleteCandBean"/>
	<jsp:setProperty property="candId" name="db" param="id"/>
	
	${db.deleteCand()}
	
	<c:choose>
		
		<c:when test="${db.count == 1}">
			
			<jsp:forward page="result.jsp">
				
				<jsp:param value="Candidate Deleted" name="msg2"/>
				
			</jsp:forward>
			<jsp:forward page="result.jsp">
				
				<jsp:param value="Candidate Delete failed" name="msg2"/>
				
			</jsp:forward>
			
			
		</c:when>
		
	</c:choose>
	

</body>
</html>
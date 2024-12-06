<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit</title>
</head>
<body>
	<jsp:useBean id="fcb" class="com.sunbeam.jspBeans.findCandBean"/>
	<jsp:setProperty property="candId" name="fcb" param="id"/>
	${fcb.findCandidate()}
	
	<form method="post" action="updateCand.jsp">
		<input type="hidden" name="candId" value="${fcb.cand.id}"/>
		Name: <input type="text" name="name" value="${fcb.cand.name}"/> <br/><br/>
		Party: <input type="text" name="party" value="${fcb.cand.party}"/> <br/><br/>
		Votes: <input type="text" name="votes" readonly="readonly" value="${fcb.cand.votes}"/> <br/><br/>
		<input type="submit" value="Update"/>
	</form>

</body>
</html>
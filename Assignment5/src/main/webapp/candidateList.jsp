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


<jsp:useBean id="clb" class="com.sunbeam.jspBeans.CandidateListBean"/>
${clb.displayCandidates()}

<form method="post" action="vote.jsp">
	<c:forEach var="cand" items="${clb.candList }">
		<input type="radio" name="candidate" value="${cand.id}"/>${cand.name} - ${cand.party}<br/>
	
	</c:forEach>
	<input type="submit" value="vote"/>

</form>

</body>
</html>
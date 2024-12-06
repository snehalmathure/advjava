<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>result</title>
</head>
<body>

	<h1>Voting status</h1>
	<jsp:useBean  id="res" class="com.sunbeam.jspBeans.ResultBean"/>
	
	${res.fetchCandidates()}
	
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Party</th>
				<th>Votes</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach var="c" items="${res.candList}">
				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>
					<td>${c.party}</td>
					<td>${c.votes}</td>
					<td>
						<a href="editcand.jsp?id=${c.id}">
							<img src="images/edit.png" alt="Edit" width="20" height="20"/>
						</a>
						<a href="delcand.jsp?id=${c.id}">
							<img src="images/delete.png" alt="Delete" width="20" height="20"/>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
	
	<p>${param.msg}</p>
	<p>${param.msg2} </p>
	<p>${param.addmsg}</p>
	
	<p><a href="newcand.jsp">new Candidate</a></p>
	<p>
	<a href="logout.jsp">Sign Out</a>
	</p>	

</body>
</html>
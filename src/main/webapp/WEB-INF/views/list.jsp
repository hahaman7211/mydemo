<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" >
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
<%
	/*if(request.getSession().getAttribute("employee")==null)
		response.sendRedirect(request.getContextPath());*/
%>	

	
	
<body>
	<div id="wrapper">
		<div id="header">
			<h2>My Account</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<input type="button" value="add customer" 
				onclick="window.location.href='showform'; return false" 
				class="add-button" />
		
			<table>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>			
				<c:forEach var="theuser" items="${alluser }">
					<tr>
						<c:url var="update" value="updateCustomer">
							<c:param name="uid" value="${theuser.id }"/>		
						</c:url>
						<c:url var="delete" value="deleteCustomer">
							<c:param name="uid" value="${theuser.id }"/>		
						</c:url>
						<td>${theuser.id }</td>
						<td>${theuser.firstname }</td>
						<td>${theuser.lastname }</td>
						<td>${theuser.email }</td>
						<td><a href=${update }>update</a></td>
						<td><a href=${delete }>delete</a></td>
					</tr>
				</c:forEach>
			</table>
			
		</div>
	</div>

<a href="/mydemo/secController">sec controller</a>



</body>
</html>
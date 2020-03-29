<html>


<%
	/*if(request.getSession().getAttribute("employee")==null) {
		response.sendRedirect(request.getContextPath());
	}*/
%>





<body>

	<h2>homepage</h2>

</body>

<table>
	<tr>
		<th>name</th>
		<th>password</th>
		<th>email</th>
	</tr>
	
	<tr>
		<td>${loginEmlp.username }</td>
		<td>${loginEmlp.password }</td>
		<td>${loginEmlp.email }</td>
	</tr>

</table>
<br>

<input type="button" value="List"
	onclick="window.location.href='dolist';return false" />
<br>
<br>



</html>
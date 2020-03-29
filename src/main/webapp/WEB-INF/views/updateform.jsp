<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="doUpdateUser" method="post">
	
		<input type="hidden" name="theid" value=${theUser.id } />
	
		first name: <input type="text" name="firstname" value=${theUser.firstname } /><br><br>
		
		last name: <input type="text" name="lastname" value=${theUser.lastname } /><br><br>
		
		email: <input type="text" name="email" value=${theUser.email } /><br><br>
	
		<input type="submit" value="submit" />
	
	</form>






</body>
</html>
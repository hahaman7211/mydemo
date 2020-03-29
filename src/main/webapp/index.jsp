<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
	function isValidForm() {
		var username = $("#username").val();
		var password = $("#password").val();
		if (username == "" || password == "") {
			alert("username or password cannot be empty!");
			return false;
		} else
			return true;
	}
</script>


</head>

<body>
	<h2>Log in</h2>

	<!-- dolist controller is within homepage controller, 
	so the request(url) is /homepage/dolist  -->
	<form action="homepage/login" method="post"
		onsubmit="return isValidForm()">
		Username: <input type="text" name="username" id="username" /><br><br>
		 
		password: <input type="text" name="password" id="password" /><br><br>
		<h3 style="color: red">${note }</h3>

		<input type="submit" value="login" />
	</form>

	<input type="button" value="sign up"
		onclick="window.location.href='homepage/signupform'; return false" />
	<br>
	<br>

	<!--  
<c:url var="jay" value="page4.jsp"></c:url>
<a href="${jay }">page4</a>-->

	<a href="homepage/newpage">call homepage</a>
	<br>
	<a href="secController">call secController</a>
	<br>
	
	<!-- it can only link to the page under static file folder -->
	<a href="page2.jsp">page2</a>
	<br>
	




</body>
</html>

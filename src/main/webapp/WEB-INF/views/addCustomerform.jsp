<html>

<head>
	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" >
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>


<body>
	<div id="wrapper">
		<div id="header">
			<h2>Add a new customer</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">

			<form action="addcustomer" method="post">
				enter first name: <input type="text" name="firstname" /><br/>
				enter last name: <input type="text" name="lastname" /><br/>
				enter email: <input type="text" name="email" /><br/>
				<input type="submit" value="Submit" />
		
			</form>
		</div>
	</div>
	


</body>





</html>
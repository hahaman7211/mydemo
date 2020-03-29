<html>

<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>

	function isValidForm() {
		var username = $("#username").val();
		var password = $("#password").val();
		var repassword = $("#repassword").val();
		var email = $("#email").val();
		var pattern = /\S+@\S+\.\S+/;
		var re = pattern.test(email)
		
		if (username=="" || password=="" || email=="") {
			alert("username, password and email cannot be empty!");
			return false;		
		} 
		else if(password!=repassword){
			alert("password is not same!");
			return false;
		}
		else if(re==false) {
			alert("wrong email address!");
			return false;
		}
		else
			return true;
	}
	
	$(document).ready(function() {
		$("#username").blur(function() {
			var username = $("#username").val();
			$.ajax(
					{
						url: "checkUsername",
						type: "POST",
						data: {theusername: username},
						error: function() {
							alert("Ajax_request get a error");
						},
						success: function(response) {
							if(response=="y") {
								alert("the username already exists!");
								$("#notice").text("the username already exists!");
								$("#submit").attr("disabled", true);
							}
								
							else {
								$("#notice").text("");
								$("#submit").attr("disabled", false);
							}
							
						}
						
			});
		});
	});
	
</script>
</head>

<body>

	<form action="addemployee" onsubmit="return isValidForm()" method="post">
		enter your username: <input type="text" name="username" id="username"/><br>
		<p id="notice"></p>
		
		enter your password: <input type="text" name="password" id="password"/><br>
		
		type your password again: <input type="text" name="repassword" 
			id="repassword" onblur="checkpw()" /><br>
			
		enter your email: <input type="text" name="email" 
			id="email" /><br>
			
		<p id="warning" style="color: red;"></p>
			
		<input type="submit" value="Submit" id="submit" />
	
	</form>
	






</body>


</html>
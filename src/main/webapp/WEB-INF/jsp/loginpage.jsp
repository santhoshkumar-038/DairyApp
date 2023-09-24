<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyDiary Login Page</title>
<link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
</head>
<body>
	<div class="header">
		<div class="first">
			<img src="<c:url value="/images/diary.jpg"/>" width="50" height="50"/>
		</div>
		<div class="second">
			MyDiary App
		</div>
	</div>
	<br/>
	<hr/>
	
	<div class="bodypart">
		<div class="bodypart1">
			<img src="<c:url value="/images/diary.jpg"/>" />	
		</div>
		<div class="bodypart2">
			<h1>Login Here</h1><br/>
			<form action="./authenticate" method="POST">
				<label class="label">Username </label><input type="text" name="username" class="formcontrols"/><br/><br/>
				<label class="label">Password </label><input type="password" name="password" class="formcontrols"/><br/><br/>
				<button type="submit">LOGIN</button><br/><br/>
			</form>
			<br/>
			<br/>
			New User? <a href="./register">Register</a> here
		</div>
	</div>
</body>
</html>
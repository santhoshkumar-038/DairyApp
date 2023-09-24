<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyDiary Add Entry Page</title>
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
	Welcome <span style="color:SteelBlue"> ${user.username} </span>
	<a href="./signout" style="color:red;float:right">SignOut</a>
	<div class="bodypart">
		<div class="bodypart1">
			<img src="<c:url value="/images/diary.jpg"/>" />	
		</div>
		<div class="bodypart2">
			<h1>View Entry</h1><br/>
			<table>
				<tr><td style="text-align:left">Date</td><td style="text-align:left">${entry.entrydate}</td></tr>
				<tr><td style="text-align:left">Description</td><td style="text-align:left">${entry.description}</td></tr>
			</table>
			<br/><br/>
			<a href="userhome"><button type="button">Back to Home</button></a><br/><br/>
		</div>
	</div>
</body>
</html>
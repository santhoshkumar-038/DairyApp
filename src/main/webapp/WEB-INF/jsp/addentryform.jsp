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
	<a href="./signout" style="color:red;float:right">Signout</a>
	<div class="bodypart">
		<div class="bodypart1">
			<img src="<c:url value="/images/diary.jpg"/>" />	
		</div>
		<div class="bodypart2">
			<h1>Add Entry</h1><br/>
			<form action="./saveentry" method="POST">
				<label class="label">Date </label><input type="date" name="entrydate" class="formcontrols"/><br/><br/>
				<label class="label">Description </label>
				<textarea rows="10" cols="30" name="description"></textarea>
				<br/><br/>
				<input type="hidden" name="userid" value="${user.id}"/>
				<button type="submit">Save Entry</button><br/><br/>
			</form>
		</div>
	</div>
</body>
</html>
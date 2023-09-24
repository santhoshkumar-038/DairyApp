<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			<h1>Update Entry</h1><br/>
			<form action="./processentryupdate" method="POST">
				<label class="label">Date </label><input type="text" name="entrydate" class="formcontrols" value="<fmt:formatDate value="${entry.entrydate}" pattern="yyyy-MM-dd"/>" readonly/><br/><br/>
				<label class="label">Description </label>
				<textarea rows="10" cols="30" name="description">${entry.description}</textarea>
				<br/><br/>
				<input type="hidden" name="userid" value="${user.id}"/>
				<input type="hidden" name="id" value="${entry.id}"/>
				<button type="submit">Update Entry</button><br/><br/>
			</form>
		</div>
	</div>
</body>
</html>
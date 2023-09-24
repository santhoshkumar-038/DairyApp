<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MyDiary Login Page</title>
<link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
</head>
<body>
	<div class="header">
		<div class="first"><img src="<c:url value="/images/diary.jpg"/>" width="50" height="50"/></div>
		<div class="second">MyDiary App</div>
	</div>
	
	<br/>
	
	<hr/>
	<br/>
	<div class="userhome1">
		Welcome <span style="color:SteelBlue"> ${user.username} </span>
		<a href="./signout" style="color:red;float:right">Signout</a>
	</div>
	
	<br/><br/><br/><br/>
	<span class="heading" style="font-size:20px;color:orange">List of Past Entries</span>
	<a href="./addentry">
		<button type="button" class="addbtn" style="float:right;background-color:steelblue;color:white;margin-bottom:12px">
			Add Entry
		</button>
	</a>
	<br/><br/>
	<table border="1" style="width:90%;margin:0 auto auto;">
		<tr>
		<th>Date</th>
		<th colspan="3">Actions</th>
		</tr>
		
		<c:if test="${entrieslist.size() == 0}">
			<tr><td style="color:green;text-align:center;padding:10px" colspan="4">User not added any Diary entries till now</td></tr>
		</c:if>
		
		<c:forEach items="${entrieslist}" var="e">
		<tr>
			<td style="padding:10px"> <fmt:formatDate value="${e.entrydate}" pattern="dd/MM/yyyy"/> </td>
			<td style="padding:10px"><a href="./viewentry?id=${e.id}">View</a></td>
			<td style="padding:10px"><a href="./updateentry?id=${e.id}">Update</a></td>
			<td style="padding:10px"><a href="./deleteentry?id=${e.id}">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
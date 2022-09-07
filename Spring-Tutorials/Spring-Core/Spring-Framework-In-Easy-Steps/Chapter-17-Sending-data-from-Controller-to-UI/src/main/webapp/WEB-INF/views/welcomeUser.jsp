<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.tutorials.sid.spring.module.dto.User"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome User And Last Edit</title>
</head>
<body>
	<h1>Welcome :</h1>
	<b>${user.name}</b>
	<form action="userEditRegistration" method="post">
		Id: <input type="text" name="userid" value="${user.id}"><br />
		Name: <input type="text" name="username" value="${user.name}"><br />
		Email: <input type="text" name="useremail" value="${user.email}"><br />
		<input type="submit" name="Edit-User"><br />
	</form>
</body>
</html>
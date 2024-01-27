<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
	<pre>
		My First JSP!!! Welcome to ${name}!!!<br /> 
		<a href="/list-todos?name=${name}">Click here</a> to check the TODOS...
	</pre>
</body>
</html>
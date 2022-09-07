<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC</title>
</head>
<body>
	<h1>Welcome to Spring MVC</h1>
	<%
		Integer id = (Integer) request.getAttribute("id");
		String firstName = (String) request.getAttribute("firstName");
		String lastName = (String) request.getAttribute("lastName");
		out.println("ID :" + id);
		out.println("First Name:" + firstName);
		out.println("Last Name:" + lastName);
	%>
	<br /> 
	ID:<b>${id}</b> <br/>
	First Name:<b>${firstName}</b> <br/>
	Last Name:<b>${lastName}</b><br/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.tutorials.sid.spring.module.dto.Employee"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Object Details display</title>
</head>
<body>
	<%
	Employee employees = (Employee) request.getAttribute("employee");
	out.println(employees.getId());
	out.println(employees.getFirstName());
	out.println(employees.getLastName());
	%>
</body>
</html>
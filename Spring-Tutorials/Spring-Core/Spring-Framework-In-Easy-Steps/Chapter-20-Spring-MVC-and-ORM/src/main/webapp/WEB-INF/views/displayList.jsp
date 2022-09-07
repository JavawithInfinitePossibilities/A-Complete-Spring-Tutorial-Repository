<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.tutorials.sid.spring.module.dto.Employee"
	import="java.util.List"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Employee List</title>
</head>
<body>
	<%
		List<Employee> employees = (List<Employee>) request.getAttribute("employees");
		for (Employee e : employees) {
			out.println(e.getId());
			out.println(e.getFirstName());
			out.println(e.getLastName());
		}
	%>
</body>
</html>
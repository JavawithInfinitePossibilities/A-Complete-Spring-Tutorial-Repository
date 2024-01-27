<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Yahoo!!</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<pre>
		Your password is : ${password}
		<div class="container">
			<table class="table table-striped">
				<caption>Your todos are</caption>
				<thead>
					<tr>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is it Done?</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${TODOList}" var="todo">
						<tr>
							<td>${todo.desc}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
							<td><a type="button" class="btn btn-warning"
								href="/delete-todo?id=${todo.id}">Delete</a></td>
							<td><a type="button" class="btn btn-warning"
								href="/display-todo?id=${todo.id}">Display</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		<div> 
			<a class="button" href="/add-todo">Add a Todo</a>
		</div>
		</div>
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	</pre>
</body>
</html>
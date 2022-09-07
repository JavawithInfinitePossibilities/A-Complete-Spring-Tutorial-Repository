<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.tutorials.sid.spring.model.Todo"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display TODO</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<form:form action="/update-list-todos" method="post" commandName="todo">
		<div class="container">
			<table class="table table-striped">
				<caption>Your todos are</caption>
				<thead>
					<tr>
						<th>ID</th>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is it Done?</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input name="id" type="text" class="form-control"
							required="required" value="${todo.id}" /></td>
						<td><input path="desc" name="desc" type="text"
							class="form-control" required="required" value="${todo.desc}" /></td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
					</tr>
				</tbody>
			</table>
		</div>
		<form:errors path="desc" cssClass="text-warning" />
		<input type="submit" name="Update" class="btn btn-warning">
	</form:form>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
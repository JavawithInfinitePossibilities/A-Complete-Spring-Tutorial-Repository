<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show all product</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Product Name</th>
			<th>Product Description</th>
			<th>Product Price</th>
		</tr>

		<c:forEach items="${allproductDetails}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>${product.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
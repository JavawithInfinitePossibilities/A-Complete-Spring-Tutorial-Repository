<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.tutorials.sid.spring.module.dto.ProductDto"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Product Verification :</h1>
	<form action="productverificationconfirm" method="post">
		Product-Name:<input type="text" name="productname"
			value="${product.name}"><br /> Product-Description: <input
			type="text" name="productdescription" value="${product.description}"><br />
		Product-Price: <input type="text" name="productprice"
			value="${product.price}"><br /> <input type="submit"
			name="Edit-Product"><br />
	</form>
</body>
</html>
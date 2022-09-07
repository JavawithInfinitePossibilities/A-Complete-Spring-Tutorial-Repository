<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
	<font color="red">${errormessage}</font>
	<form method="post">
		<pre>
			Name : <input type="text" name="name" /> 
			Password : <input type="password" name="password">
			<input type="submit" id="Submit" />
		</pre>
	</form>

</body>
</html>
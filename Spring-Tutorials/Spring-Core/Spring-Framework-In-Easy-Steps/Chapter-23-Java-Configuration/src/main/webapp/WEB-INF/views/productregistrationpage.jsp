<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Registration</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#name").change(function() {
			$.ajax({
				url:'validateproductname',
				data:{name:$("#name").val()},
				success:function(responsetext){
					$("#errMsg").text(responsetext);
					if(responsetext!=""){
						$("#name").focus();
					}
				}
			})
		})
	});
</script>
</head>
<body>
	<form action="productregistration" method="post">
		Product-Name: <input type="text" name="name" id="name"><b><span id="errMsg"></span></b><br />
		Product-Description: <input type="text" name="description"><br />
		Product-Price: <input type="text" name="price"><br /> <input
			type="submit" name="Registration"><br />
	</form>
</body>
</html>
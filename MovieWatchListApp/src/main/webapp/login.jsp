<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>

	<form method="POST"  action="LoginServlet">
		<h1>Login Form</h1>
		<br>
		<%final String message = (String) request.getAttribute("message");%>
		<h3>${message}</h3>
		
		<div>
		<label>Email : </label>
		<input type="email" name="email" >
		</div>
		<div>
		<label>Password : </label>
		<input type="password" name="password" >
		</div>
		<input type="submit" value="Submit">
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Signup</title>
</head>
<body>
<%final String message = (String) request.getAttribute("message");%>
	<h3>${message}</h3>
	<form action="SignupServlet" method="POST">
		<div>
		<label>Email :</label>
		<input type="email" name="email">
		</div>
		<br>
		<div>
		<label>Password :</label>
		<input type="password" name="password">
		</div>
		<br>
		<div>
		<label>First Name :</label>
		<input type="text" name="firstName">
		</div>
		<br>
		<div>
		<label>Last Name :</label>
		<input type="text" name="lastName">
		</div>
		<br>
		<div>
		<label>Gender :</label>
		<div>
		<label>Male : </label>
		<input type="radio" value="Male" name="gender">
		</div>
		<div>
		<label>Female : </label>
		<input type="radio" value="Female" name="gender">
		</div>
		</div>
		<br>
		<input type="submit" value="Signup">
	</form>
</body>
</html>
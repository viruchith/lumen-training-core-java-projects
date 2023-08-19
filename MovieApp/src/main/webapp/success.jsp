<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>

<% 

String username = (String)session.getAttribute("username");

out.print("<h1> Welcome, "+username+"</h1>");

%>

<form action="movies" method="GET">
	<select name="language" >
	<option value="Tamil" >Tamil</option>
	<option value="English" >English</option>
	<option value="Malayalam" >Malayalam</option>
</select>
<input type="submit" value="Submit">
</form>

</body>
</html>
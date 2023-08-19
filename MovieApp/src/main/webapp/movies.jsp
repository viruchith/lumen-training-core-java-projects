<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movies</title>
</head>
<body>
<h1>Movies : </h1>
	<%
	
	List<String> movies = (List<String>)request.getAttribute("movies");
		
	for(String movie : movies){
		out.print("<h3>"+movie+"</h3>");
	}
	%>
</body>
</html>
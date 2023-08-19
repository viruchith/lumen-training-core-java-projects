<%@page import="com.movieapp.model.WatchList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${user.firstName} ${user.lastName}'s Lists</title>
</head>
<body>
	<%final List<WatchList> watchLists = (List<WatchList>)request.getAttribute("watchLists"); %>
	<form action="MyListsServlet" method="POST">
	<h2>ADD Watch List</h2>
	<input type="text" name="title" required>
	<input type="submit" value="ADD">
	</form>
	<br>
	<hr>
	<br>
	<h2>WatchLists</h2>
	<ul>
	<c:forEach var="watchList" items="${watchLists}">
		<li>${watchList.title}</li>
	</c:forEach>
	</ul>
</body>
</html>
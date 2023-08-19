<%@page import="com.movieapp.util.MovieSearchResult"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search movies :</title>
<style>
body {
	font-size: 1rem;
}

table, tr, th, td {
	border: 0.2rem solid black;
	padding: 0.5rem;
	margin: 1rem;
}

th {
	font-weight: bold;
}
</style>
</head>
<body>
	<%
	final List<MovieSearchResult> results = (List<MovieSearchResult>) request.getAttribute("results");
	%>
	<form action="SearchServlet" method="GET">
		<label>Title</label> <input type="search" name="title" required>
		<br> <input type="submit" value="Search">
	</form>
	<br>
	<span><a href="MyListsServlet">My Lists</a></span>
	<br>
	<hr>
	<br>
	<c:if test="${results!=null}">
		<center><h3>Search Results</h3></center>
		<table>
			<thead>
				<tr>
					<th>IMDB ID</th>
					<th>Title</th>
					<th>Year</th>
					<th>Poster</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="result" items="${results}">
					<tr>
						<td><a href="MovieServlet?imdbID=${result.imdbID}"><c:out value="${result.imdbID}" /></a></td>
						<td><c:out value="${result.title}" /></td>
						<td><c:out value="${result.year}" /></td>
						<td><img src="${result.poster}"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</body>
</html>
<%@page import="com.movieapp.model.Movie"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%
final Movie movie = (Movie) request.getAttribute("movie");
%>
<title>${movie.title}</title>
<style>
table, th, td {
	border: 0.2rem solid black;
}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>#</th>
				<th>##</th>
			</tr>
		</thead>
		<tbody>
			<tr>
			<td>Poster : </td>
			<td><img src="${movie.poster}"></td>
			</tr>
			<tr>
				<td>IMDB ID :</td>
				<td>${movie.imdbID}</td>
			</tr>

			<tr>
				<td>Title :</td>
				<td>${movie.title}</td>
			</tr>
			<tr>
				<td>Runtime :</td>
				<td>${movie.runtime}</td>
			</tr>
			<tr>
				<td>Release Date :</td>
				<td>${movie.releaseDate}</td>
			</tr>
			<tr>
				<td>Genre :</td>
				<td>${movie.genre}</td>
			</tr>
			<tr>
				<td>Director :</td>
				<td>${movie.director}</td>
			</tr>
			<tr>
				<td>Actors :</td>
				<td>${movie.actors}</td>
			</tr>
			<tr>
				<td>Language :</td>
				<td>${movie.language}</td>
			</tr>
			<tr>
				<td>Plot :</td>
				<td>
					<p></p>${movie.plot}</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
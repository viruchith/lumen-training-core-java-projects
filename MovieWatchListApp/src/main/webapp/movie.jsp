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
				<td>IMDB ID : </td>
				<td>Title : </td>
				<td>Runtime : </td>
				<td>Release Date : </td>
				<td>Genre : </td>
				<td>Director : </td>
				<td>Actors : </td>
				<td>Languages : </td>
				<td>Plot : </td>
			</tr>

			<tr>
				<td>${movie.imdbID}</td>
				<td>${movie.title}</td>
				<td>${movie.runtime}</td>
				<td>${movie.releaseDate}</td>
				<td>${movie.genre}</td>
				<td>${movie.director}</td>
				<td>${movie.actors}</td>
				<td>${movie.language}</td>
				<td>Plot :
					<p></p>${movie.plot}</td>
			</tr>

		</tbody>
	</table>
</body>
</html>
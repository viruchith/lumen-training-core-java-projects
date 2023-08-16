package com.movieapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.movieapp.model.Movie;
import com.movieapp.model.User;
import com.movieapp.util.DBConnection;
import com.movieapp.util.MovieQueries;
import com.movieapp.util.UserQueries;

public class MovieDaoImpl implements IMovieDao {

	
	@Override
	public boolean addMovie(Movie movie) {
		try(Connection connection = DBConnection.openConnection(); PreparedStatement preparedStatement = connection.prepareStatement(MovieQueries.MOVIE_INSERT_QUERY)) {
			preparedStatement.setString(1, movie.getImdbID());
			preparedStatement.setString(2, movie.getTitle());
			preparedStatement.setString(3, movie.getRuntime());
			preparedStatement.setString(4, movie.getReleaseDate());
			preparedStatement.setString(5, movie.getGenre());
			preparedStatement.setString(6, movie.getDirector());
			preparedStatement.setString(7, movie.getActors());
			preparedStatement.setString(8, movie.getLanguage());
			preparedStatement.setString(9, movie.getPlot());
			preparedStatement.setString(10, movie.getPoster());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;		
	}

	@Override
	public Movie findByImdbID(String imdbID) {
		try(Connection connection = DBConnection.openConnection(); PreparedStatement preparedStatement = connection.prepareStatement(MovieQueries.MOVIE_SELECT_BY_IMDBID)) {
			preparedStatement.setString(1, imdbID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				Movie movie = new Movie();
				
				movie.setId(resultSet.getInt("id"));
				movie.setImdbID(resultSet.getString("imdbID"));
				movie.setTitle(resultSet.getString("Title"));
				movie.setRuntime(resultSet.getString("Runtime"));
				movie.setReleaseDate(resultSet.getString("ReleaseDate"));
				movie.setGenre(resultSet.getString("Genre"));
				movie.setDirector(resultSet.getString("Director"));
				movie.setActors(resultSet.getString("Actors"));
				movie.setLanguage(resultSet.getString("Language"));
				movie.setPlot(resultSet.getString("Plot"));
				movie.setPoster(resultSet.getString("Poster"));
				
				return movie;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Movie findById(Integer id) {
		try(Connection connection = DBConnection.openConnection(); PreparedStatement preparedStatement = connection.prepareStatement(MovieQueries.MOVIE_SELECT_BY_ID)) {
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				Movie movie = new Movie();
				
				movie.setId(resultSet.getInt("id"));
				movie.setImdbID(resultSet.getString("imdbID"));
				movie.setTitle(resultSet.getString("Title"));
				movie.setRuntime(resultSet.getString("Runtime"));
				movie.setReleaseDate(resultSet.getString("ReleaseDate"));
				movie.setGenre(resultSet.getString("Genre"));
				movie.setDirector(resultSet.getString("Director"));
				movie.setActors(resultSet.getString("Actors"));
				movie.setLanguage(resultSet.getString("Language"));
				movie.setPlot(resultSet.getString("Plot"));
				movie.setPoster(resultSet.getString("Poster"));
				
				return movie;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

package com.movieapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.movieapp.model.Movie;
import com.movieapp.model.User;
import com.movieapp.model.WatchList;
import com.movieapp.service.IMovieService;
import com.movieapp.service.MovieServiceImpl;
import com.movieapp.util.DBConnection;
import com.movieapp.util.MovieQueries;
import com.movieapp.util.WatchListQueries;

public class WatchListDaoImpl implements IWatchListDao {
	
	private IMovieService movieService = new MovieServiceImpl();

	@Override
	public boolean addWatchList(User user, WatchList watchList) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(WatchListQueries.INSERT_WATCHLIST_QUERY)) {
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, watchList.getTitle());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<WatchList> findByUser(User user) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(WatchListQueries.SELECT_WATCHLIST_BY_USER)) {
			preparedStatement.setInt(1, user.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			List<WatchList> watchLists = new ArrayList<WatchList>();
			while(resultSet.next()) {
				WatchList watchList = new WatchList();
				watchList.setId(resultSet.getInt("id"));
				watchList.setUserId(resultSet.getInt("userId"));
				watchList.setTitle(resultSet.getString("Title"));
				watchList.setCreatedAt(resultSet.getString("createdAt"));
				
				watchLists.add(watchList);
			}
			
			return watchLists;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public WatchList findById(Integer id) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(WatchListQueries.SELECT_WATCHLIST_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				WatchList watchList = new WatchList();
				watchList.setId(resultSet.getInt("id"));
				watchList.setUserId(resultSet.getInt("userId"));
				watchList.setTitle(resultSet.getString("Title"));
				watchList.setCreatedAt(resultSet.getString("createdAt"));

				return watchList;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addMovieToWatchList(Movie movie, WatchList watchList) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(WatchListQueries.INSERT_MOVIE_TO_WATCHLIST)) {
			preparedStatement.setInt(1, watchList.getId());
			preparedStatement.setInt(2, movie.getId());
			preparedStatement.execute();
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void removeMovieFromWatchList(Movie movie, WatchList watchList) {
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(WatchListQueries.DELETE_MOVIE_FROM_WATCHLIST)) {
			preparedStatement.setInt(1, watchList.getId());
			preparedStatement.setInt(2, movie.getId());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Movie> findMoviesByWatchList(WatchList watchList) {
		List<Movie> movies = new ArrayList<Movie>();
		try (Connection connection = DBConnection.openConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(WatchListQueries.SELECT_MOVIES_FROM_WATCHLIST)) {
			preparedStatement.setInt(1, watchList.getId());
			ResultSet resultSet =  preparedStatement.executeQuery();
			while(resultSet.next()) {
				Movie movie = movieService.getById(resultSet.getInt("movieId"));
				movies.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		return movies;
	}

}

package com.movieapp.dao;

import java.util.List;

import com.movieapp.model.Movie;
import com.movieapp.model.User;
import com.movieapp.model.WatchList;

public interface IWatchListDao {
	boolean addWatchList(User user,WatchList watchList);
	WatchList findByUser(User user);
	WatchList findById(Integer id);
	boolean addMovieToWatchList(Movie movie,WatchList watchList);
	void removeMovieFromWatchList(Movie movie,WatchList watchList);
	List<Movie> findMoviesByWatchList(WatchList watchList);
}

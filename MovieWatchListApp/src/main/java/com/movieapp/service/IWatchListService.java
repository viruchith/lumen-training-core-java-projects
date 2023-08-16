package com.movieapp.service;

import java.util.List;

import com.movieapp.exception.WatchListNotFoundException;
import com.movieapp.model.Movie;
import com.movieapp.model.User;
import com.movieapp.model.WatchList;

public interface IWatchListService {
	boolean addWatchList(User user,WatchList watchList);
	WatchList getByUser(User user) throws WatchListNotFoundException;
	WatchList getById(Integer id) throws WatchListNotFoundException;
	boolean addMovieToWatchList(Movie movie,WatchList watchList);
	void removeMovieFromWatchList(Movie movie,WatchList watchList);
	List<Movie> getMoviesByWatchList(WatchList watchList) throws WatchListNotFoundException;
}

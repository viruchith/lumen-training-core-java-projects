package com.movieapp.service;

import java.util.List;

import com.movieapp.dao.IWatchListDao;
import com.movieapp.dao.WatchListDaoImpl;
import com.movieapp.exception.WatchListNotFoundException;
import com.movieapp.model.Movie;
import com.movieapp.model.User;
import com.movieapp.model.WatchList;

public class WatchListService implements IWatchListService {
	
	private IWatchListDao watchListDao = new WatchListDaoImpl();

	@Override
	public boolean addWatchList(User user, WatchList watchList) {
		return watchListDao.addWatchList(user, watchList);
	}

	@Override
	public WatchList getByUser(User user) {
		WatchList watchList = watchListDao.findByUser(user);
		if (watchList==null) {
			throw new WatchListNotFoundException();
		}
		return watchList;
	}

	@Override
	public WatchList getById(Integer id) {
		WatchList watchList = watchListDao.findById(id);
		if(watchList==null) {
			throw new WatchListNotFoundException();
		}
		return watchList;
	}

	@Override
	public boolean addMovieToWatchList(Movie movie, WatchList watchList) {
		return watchListDao.addMovieToWatchList(movie, watchList);
	}

	@Override
	public void removeMovieFromWatchList(Movie movie, WatchList watchList) {
		watchListDao.removeMovieFromWatchList(movie, watchList);
	}

	@Override
	public List<Movie> getMoviesByWatchList(WatchList watchList) {
		List<Movie> movies = watchListDao.findMoviesByWatchList(watchList);
		if(movies.isEmpty()) {
			throw new WatchListNotFoundException();
		}
		watchList.setMovies(movies);
		return movies;
	}

}

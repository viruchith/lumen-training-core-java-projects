package com.movieapp.service;

import com.movieapp.dao.IMovieDao;
import com.movieapp.dao.MovieDaoImpl;
import com.movieapp.exception.MovieAlreadyExistException;
import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Movie;

public class MovieServiceImpl implements IMovieService {
	
	private IMovieDao movieDao = new MovieDaoImpl();

	@Override
	public void addMovie(Movie movie) throws MovieAlreadyExistException {
		boolean success = movieDao.addMovie(movie);
		if(!success) {
			throw new MovieAlreadyExistException();
		}
	}

	@Override
	public Movie getByImdbID(String imdbID) throws MovieNotFoundException {		// TODO Auto-generated method stub
		Movie movie =  movieDao.findByImdbID(imdbID);
		if(movie==null)
			throw new MovieNotFoundException();
		return movie;
	}

	@Override
	public Movie getById(Integer id) throws MovieNotFoundException {
		Movie movie =  movieDao.findById(id);
		if(movie==null)
			throw new MovieNotFoundException();
		return movie;
	}

		
}

package com.movieapp.service;

import com.movieapp.exception.MovieAlreadyExistException;
import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Movie;

public interface IMovieService {
	void addMovie(Movie movie) throws MovieAlreadyExistException;

	Movie getByImdbID(String imdbID) throws MovieNotFoundException;

	Movie getById(Integer id) throws MovieNotFoundException;
}

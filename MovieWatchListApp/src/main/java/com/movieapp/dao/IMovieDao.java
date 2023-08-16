package com.movieapp.dao;

import com.movieapp.model.Movie;
import com.movieapp.model.User;

public interface IMovieDao {
	boolean addMovie(Movie movie);
	Movie findByImdbID(String imdbID);
	Movie findById(Integer id);
}

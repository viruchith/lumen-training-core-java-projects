package com.movieapp.client;

import java.util.List;

import com.movieapp.model.Movie;
import com.movieapp.model.User;
import com.movieapp.model.WatchList;
import com.movieapp.service.IMovieService;
import com.movieapp.service.IUserService;
import com.movieapp.service.IWatchListService;
import com.movieapp.service.MovieServiceImpl;
import com.movieapp.service.UserServiceImpl;
import com.movieapp.service.WatchListService;
import com.movieapp.util.MovieFetcher;
import com.movieapp.util.MovieSearchResult;

public class Main {
	public static void main(String[] args) {
//		User user = new User();
//		user.setEmail("v2@g.com");
//		user.setPassword("admin123");
//		user.setFirstName("Viruchith");
//		user.setLastName("Ganesan");
//		user.setGender("MALE");
//		
//		UserServiceImpl userServiceImpl = new UserServiceImpl();
////		userServiceImpl.addUser(user);
//		
//		user  = userServiceImpl.getByEmail("v@g.com");
//		user = userServiceImpl.getById(4);
//		System.out.println(user)

//		IMovieService movieService = new MovieServiceImpl();
//		List<MovieSearchResult> movieSearchResults =  MovieFetcher.fetchMoviesByTitle("Django");
//		
//		MovieSearchResult movieSearchResult = movieSearchResults.get(0);
//		
//		
//		Movie movie = MovieFetcher.fetchMovieByImdbID(movieSearchResult.getImdbID());
//		
//		
////		movieService.addMovie(movie);
//		
//		System.out.println(movieService.getById(1));
		
		IUserService userService = new UserServiceImpl();
		
		IMovieService movieService = new MovieServiceImpl();
		
		IWatchListService watchListService = new WatchListService();
		
		User user = userService.getById(1);
		
		//movieService.addMovie(MovieFetcher.fetchMovieByImdbID("tt2230358"));
		
		WatchList watchList = new WatchList();
		watchList.setTitle("Watch Later");
		
//		watchListService.addWatchList(user, watchList);
		
		watchList = watchListService.getById(1);
		
//		watchListService.addMovieToWatchList(movieService.getById(4), watchList);
		
		 List<WatchList> watchLists = watchListService.getByUser(user);
		 System.out.println(watchLists);
		 
		 System.out.println(watchListService.getMoviesByWatchList(watchList));
		
	}
}

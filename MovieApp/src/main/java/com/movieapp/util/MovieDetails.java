package com.movieapp.util;

import java.util.Arrays;
import java.util.List;

public class MovieDetails {
	public List<String> showMovie(String language){
		List<String> movies;
		if(language.equals("Tamil")) {
			movies = Arrays.asList("Good night","Jailer","Maaveeran");
		}else if(language.equals("English")) {
			movies = Arrays.asList("Mission Impossible","John Wick","Oppenheimer");
		}else {
			movies = Arrays.asList("Minnal Murali","Charlie","Premam");
		}
		return movies;
	}
}

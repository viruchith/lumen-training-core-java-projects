package com.movieapp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

import com.movieapp.model.Movie;

public class MovieFetcher {

	private static String MAIN_URL = "https://www.omdbapi.com/?apikey=d1cc7d39";

	private static String encodeQueryParam(String param) {
		return URLEncoder.encode(param, StandardCharsets.UTF_8);
	}

	private static String fetch(String URL) {
		URL url;
		try {
			url = new URL(URL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(2000);
			con.setRequestMethod("GET");

			String result = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
					.collect(Collectors.joining("\n"));
			return result;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<MovieSearchResult> fetchMoviesByTitle(String title) {
		List<MovieSearchResult> movieSearchResults = new ArrayList<MovieSearchResult>();
		String responseBody = fetch(MAIN_URL + "&s=" + encodeQueryParam(title));
		JSONObject jsonObject = new JSONObject(responseBody);
		JSONArray results = jsonObject.getJSONArray("Search");
		results.forEach(result -> {
			MovieSearchResult movieSearchResult = new MovieSearchResult();

			JSONObject resultObject = (JSONObject) result;

			movieSearchResult.setImdbID(resultObject.getString("imdbID"));
			movieSearchResult.setTitle(resultObject.getString("Title"));
			movieSearchResult.setYear(resultObject.getString("Year"));
			movieSearchResult.setPoster(resultObject.getString("Poster"));

			movieSearchResults.add(movieSearchResult);

		});

		return movieSearchResults;

	}
	
	
	public static Movie fetchMovieByImdbID(String imdbID) {
		String responseBody = fetch(MAIN_URL + "&i=" + encodeQueryParam(imdbID));
		JSONObject jsonObject = new JSONObject(responseBody);
		if(jsonObject.getString("Response").equalsIgnoreCase("True")) {
			Movie movie = new Movie();
			
			movie.setImdbID(jsonObject.getString("imdbID"));
			movie.setTitle(jsonObject.getString("Title"));
			movie.setRuntime(jsonObject.getString("Runtime"));
			movie.setReleaseDate(jsonObject.getString("Released"));
			movie.setGenre(jsonObject.getString("Genre"));
			movie.setDirector(jsonObject.getString("Director"));
			movie.setActors(jsonObject.getString("Actors"));
			movie.setLanguage(jsonObject.getString("Language"));
			movie.setPlot(jsonObject.getString("Plot"));
			movie.setPoster(jsonObject.getString("Poster"));
			
			return movie;
			
		}
		return null;
	}
	
}

package com.movieapp.model;

public class Movie {
	private Integer id;
	private String imdbID;
	private String title;
	private String runtime;
	private String releaseDate;
	private String genre;
	private String director;
	private String actors;
	private String language;
	private String plot;
	private String poster;
	
	public Movie() {
		super();
	}

	public Movie(Integer id, String imdbID, String title, String runtime, String releaseDate, String genre,
			String director, String actors, String language, String plot, String poster) {
		super();
		this.id = id;
		this.imdbID = imdbID;
		this.title = title;
		this.runtime = runtime;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.director = director;
		this.actors = actors;
		this.language = language;
		this.plot = plot;
		this.poster = poster;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImdbID() {
		return imdbID;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", imdbID=" + imdbID + ", title=" + title + ", runtime=" + runtime + ", releaseDate="
				+ releaseDate + ", genre=" + genre + ", director=" + director + ", actors=" + actors + ", language="
				+ language + ", plot=" + plot + ", poster=" + poster + "]";
	}

	
}

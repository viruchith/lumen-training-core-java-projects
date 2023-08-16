package com.movieapp.model;

import java.util.List;

public class WatchList {
	private Integer id;
	private Integer userId;
	private String title;
	private String createdAt;
	private List<Movie> movies;
	
	public WatchList() {
		super();
	}

	public WatchList(Integer id, Integer userId, String title, String createdAt, List<Movie> movies) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.createdAt = createdAt;
		this.movies = movies;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "WatchList [id=" + id + ", userId=" + userId + ", title=" + title + ", createdAt=" + createdAt
				+ ", movies=" + movies + "]";
	}

	
}

package com.movieapp.util;

public class MovieQueries {
	public static final String MOVIE_CREATE_QUERY = "CREATE TABLE IF NOT EXISTS `moviedb`.`movies` ( `id` INT NOT NULL AUTO_INCREMENT, `imdbID` VARCHAR(45) NOT NULL, `title` VARCHAR(256) NOT NULL, `runtime` VARCHAR(256) NOT NULL, `releaseDate` VARCHAR(256) NOT NULL, `genre` VARCHAR(256) NOT NULL, `director` VARCHAR(256) NOT NULL, `actors` VARCHAR(256) NOT NULL, `language` VARCHAR(256) NOT NULL, `plot` VARCHAR(512) NOT NULL, `poster` VARCHAR(512) NULL, PRIMARY KEY (`id`), UNIQUE INDEX `imdbID_UNIQUE` (`imdbID` ASC) VISIBLE);";
	public static final String MOVIE_INSERT_QUERY = "INSERT INTO `moviedb`.`movies` (`id`, `imdbID`, `title`, `runtime`, `releaseDate`, `genre`, `director`, `actors`, `language`, `plot`, `poster`) VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	public static final String MOVIE_SELECT_BY_IMDBID = "SELECT `movies`.`id`, `movies`.`imdbID`, `movies`.`title`, `movies`.`runtime`, `movies`.`releaseDate`, `movies`.`genre`, `movies`.`director`, `movies`.`actors`, `movies`.`language`, `movies`.`plot`, `movies`.`poster` FROM `moviedb`.`movies` WHERE  `movies`.`imdbID` = ?";
	public static final String MOVIE_SELECT_BY_ID = "SELECT `movies`.`id`, `movies`.`imdbID`, `movies`.`title`, `movies`.`runtime`, `movies`.`releaseDate`, `movies`.`genre`, `movies`.`director`, `movies`.`actors`, `movies`.`language`, `movies`.`plot`, `movies`.`poster` FROM `moviedb`.`movies` WHERE  `movies`.`id` = ?";
}

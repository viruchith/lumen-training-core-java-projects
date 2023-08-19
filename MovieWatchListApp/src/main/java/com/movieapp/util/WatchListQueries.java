package com.movieapp.util;

public class WatchListQueries {
	public static final String CREATE_WATCHLIST_QUERY = "CREATE TABLE IF NOT EXISTS `moviedb`.`watchlists` ( `id` INT NOT NULL AUTO_INCREMENT, `userId` INT NOT NULL, `title` VARCHAR(256) NOT NULL, `createdAt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(), PRIMARY KEY (`id`), INDEX `watchlist_userid_idx` (`userId` ASC) VISIBLE, CONSTRAINT `watchlist_userid` FOREIGN KEY (`userId`) REFERENCES `moviedb`.`users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE);";
	public static final String CREATE_WATCHLLIST_MOVIES_QUERY = "CREATE TABLE IF NOT EXISTS `moviedb`.`watchlist_movies` ( `watchlistId` INT NOT NULL, `movieId` INT NOT NULL, INDEX `watchlist_movies_watchlists_fk_idx` (`watchlistId` ASC) VISIBLE, INDEX `watchlist_movies_movies_fk_idx` (`movieId` ASC) VISIBLE, INDEX `watchlist_movies_composite_key` (`watchlistId` ASC, `movieId` ASC) INVISIBLE, CONSTRAINT `watchlist_movies_watchlists_fk` FOREIGN KEY (`watchlistId`) REFERENCES `moviedb`.`watchlists` (`id`) ON DELETE CASCADE ON UPDATE CASCADE, CONSTRAINT `watchlist_movies_movies_fk` FOREIGN KEY (`movieId`) REFERENCES `moviedb`.`movies` (`id`) ON DELETE CASCADE ON UPDATE CASCADE)";
	public static final String INSERT_WATCHLIST_QUERY = "INSERT INTO `moviedb`.`watchlists` (`id`, `userId`, `title`, `createdAt`) VALUES (NULL, ?, ?, CURRENT_TIMESTAMP);";
	public static final String SELECT_WATCHLIST_BY_USER = "SELECT * FROM moviedb.watchlists WHERE userId = ? ORDER BY `createdAt` DESC";
	public static final String SELECT_WATCHLIST_BY_ID = "SELECT * FROM moviedb.watchlists WHERE id = ?";
	public static final String INSERT_MOVIE_TO_WATCHLIST = "INSERT INTO `moviedb`.`watchlist_movies` (`watchlistId`, `movieId`) VALUES (?, ?);";
	public static final String DELETE_MOVIE_FROM_WATCHLIST = "DELETE FROM `moviedb`.`watchlist_movies` WHERE watchlistId = ? AND movieId = ?;";
	public static final String SELECT_MOVIES_FROM_WATCHLIST = "SELECT `watchlist_movies`.`watchlistId`, `watchlist_movies`.`movieId` FROM `moviedb`.`watchlist_movies` WHERE `watchlist_movies`.`watchlistId` = ? ;";
}

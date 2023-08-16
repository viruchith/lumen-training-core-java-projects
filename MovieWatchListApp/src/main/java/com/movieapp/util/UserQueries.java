package com.movieapp.util;

public class UserQueries {
	public static final String CREATE_USERS  = "CREATE TABLE IF NOT EXISTS `moviedb`.`users` ( `id` INT NOT NULL AUTO_INCREMENT, `email` VARCHAR(256) NOT NULL, `password` VARCHAR(256) NOT NULL, `firstName` VARCHAR(256) NOT NULL, `lastName` VARCHAR(256) NOT NULL, `gender` VARCHAR(256) NOT NULL, PRIMARY KEY (`id`), UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);";
	public static final String INSERT_USER = "INSERT INTO `moviedb`.`users` (`id`, `email`, `password`, `firstName`, `lastName`, `gender`) VALUES (null, ?, ?, ?, ?, ?);";
	public static final String SELECT_USER_BY_EMAIL = "SELECT `users`.`id`, `users`.`email`, `users`.`password`, `users`.`firstName`, `users`.`lastName`, `users`.`gender` FROM `moviedb`.`users` WHERE `users`.`email` = ?";
	public static final String SELECT_USER_BY_ID = "SELECT `users`.`id`, `users`.`email`, `users`.`password`, `users`.`firstName`, `users`.`lastName`, `users`.`gender` FROM `moviedb`.`users` WHERE id = ?";
}

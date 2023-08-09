package com.bookapp.dao;

public class Queries {
	public static final String INSERT_QUERY = " INSERT INTO `test`.`books` (`title`, `author`, `category`, `price`) VALUES ( ?, ?, ?, ?);";
	public static final String UPDATE_QUERY = "UPDATE `test`.`books` SET  `price` = ? WHERE id = ?";
	public static final String DELETE_QUERY = "DELETE FROM books WHERE id = ?";
	public static final String  SELECT_ALL_QUERY = "SELECT * FROM books";
	public static final String SELECT_AUTHOR_LIKE_QUERY = "SELECT * FROM books WHERE author LIKE ?";
	public static final String SELECT_WHERE_CATEGORY_QUERY= "SELECT * FROM books WHERE category = ? ";
	public static final String SELECT_PRICE_LESS_THAN_QUERY = "SELECT * FROM books WHERE price < ? ";
	public static final String SELECT_WHERE_AUTHOR_AND_CATEGORY_EQUALS = "SELECT * FROM books WHERE author LIKE ? AND category = ?";
	public static final String SELECT_BY_ID = "SELECT * FROM books WHERE id = ?";
}

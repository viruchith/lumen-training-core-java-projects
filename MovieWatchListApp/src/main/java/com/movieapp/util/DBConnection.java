package com.movieapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static Connection connection;

	public static Connection openConnection() {
		String url = "jdbc:mysql://localhost:3306/moviedb";
		String username = "root";
		String password = "admin@123";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, username, password);
			java.sql.Statement statement = connection.createStatement();
			statement.addBatch(UserQueries.CREATE_USERS);
			statement.addBatch(MovieQueries.MOVIE_CREATE_QUERY);
			statement.addBatch(WatchListQueries.CREATE_WATCHLIST_QUERY);
			statement.addBatch(WatchListQueries.CREATE_WATCHLLIST_MOVIES_QUERY);
			statement.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection() {

		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

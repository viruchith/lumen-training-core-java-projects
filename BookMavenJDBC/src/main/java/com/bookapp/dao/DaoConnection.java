package com.bookapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoConnection {
	static Connection connection;

	public static Connection openConnection() {
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "admin@123";
		try {
			connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			statement.execute("CREATE TABLE IF NOT EXISTS `test`.`books` (\r\n"
					+ "  `id` INT NOT NULL AUTO_INCREMENT,\r\n" + "  `title` VARCHAR(256) NOT NULL,\r\n"
					+ "  `author` VARCHAR(256) NOT NULL,\r\n" + "  `category` VARCHAR(256) NOT NULL,\r\n"
					+ "  `price` DOUBLE NOT NULL,\r\n" + "  PRIMARY KEY (`id`));\r\n" + "");
		} catch (SQLException e) {
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

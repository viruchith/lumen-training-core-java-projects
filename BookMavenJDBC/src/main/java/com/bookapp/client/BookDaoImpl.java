package com.bookapp.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.dao.DaoConnection;
import com.bookapp.dao.Queries;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public class BookDaoImpl implements IBookDao {

	@Override
	public void addBook(Book book) {
		

		try(Connection connection = DaoConnection.openConnection(); PreparedStatement preparedStatement = connection.prepareStatement(Queries.INSERT_QUERY);) {
			
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setString(3, book.getCategory());
			preparedStatement.setDouble(4, book.getPrice());

			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void updateBook(int bookId, double price) {
		

		try(Connection connection = DaoConnection.openConnection(); PreparedStatement preparedStatement = connection.prepareStatement(Queries.UPDATE_QUERY); ) {
			
			preparedStatement.setDouble(1, price);
			preparedStatement.setInt(2, bookId);

			preparedStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void deleteBook(int bookId) {
		

		try(Connection connection = DaoConnection.openConnection(); PreparedStatement preparedStatement = connection.prepareStatement(Queries.DELETE_QUERY);){

			
			preparedStatement.setInt(1, bookId);

			preparedStatement.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> findAll() {

		

		List<Book> books = new ArrayList<Book>();

		try(Connection connection = DaoConnection.openConnection();) {

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(Queries.SELECT_ALL_QUERY);

			while (resultSet.next()) {
				Book book = new Book();
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setCategory(resultSet.getString("category"));
				book.setBookId(resultSet.getInt("id"));
				book.setPrice(resultSet.getDouble("price"));
				books.add(book);
			}

			
			return books;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;

	}

	@Override
	public List<Book> findByAuthorContains(String author) throws BookNotFoundException {

		Connection connection = DaoConnection.openConnection();

		List<Book> books = new ArrayList<Book>();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(Queries.SELECT_AUTHOR_LIKE_QUERY);
			preparedStatement.setString(1, "%" + author + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setCategory(resultSet.getString("category"));
				book.setBookId(resultSet.getInt("id"));
				book.setPrice(resultSet.getDouble("price"));
				books.add(book);
			}


			return books;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DaoConnection.closeConnection();
		}
		return null;

	}

	@Override
	public List<Book> findByCategory(String category) throws BookNotFoundException {
		

		List<Book> books = new ArrayList<Book>();

		try(Connection connection = DaoConnection.openConnection();) {

			PreparedStatement preparedStatement = connection.prepareStatement(Queries.SELECT_WHERE_CATEGORY_QUERY);
			preparedStatement.setString(1, category);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setCategory(resultSet.getString("category"));
				book.setBookId(resultSet.getInt("id"));
				book.setPrice(resultSet.getDouble("price"));
				books.add(book);
			}

						return books;

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public List<Book> findByPriceLessThan(double price) throws BookNotFoundException {
		

		List<Book> books = new ArrayList<Book>();

		try(Connection connection = DaoConnection.openConnection();) {

			PreparedStatement preparedStatement = connection.prepareStatement(Queries.SELECT_PRICE_LESS_THAN_QUERY);
			preparedStatement.setDouble(1, price);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setCategory(resultSet.getString("category"));
				book.setBookId(resultSet.getInt("id"));
				book.setPrice(resultSet.getDouble("price"));
				books.add(book);
			}

			return books;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> findByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		

		List<Book> books = new ArrayList<Book>();

		try(Connection connection = DaoConnection.openConnection();){

			PreparedStatement preparedStatement = connection.prepareStatement(Queries.SELECT_WHERE_AUTHOR_AND_CATEGORY_EQUALS);
			preparedStatement.setString(1, "%"+author+"%");
			preparedStatement.setString(2, category);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setCategory(resultSet.getString("category"));
				book.setBookId(resultSet.getInt("id"));
				book.setPrice(resultSet.getDouble("price"));
				books.add(book);
			}

			return books;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DaoConnection.closeConnection();
		}
		return null;
	}

	@Override
	public Book findById(int bookId) throws BookNotFoundException {

		

		try(Connection connection = DaoConnection.openConnection();) {

			PreparedStatement preparedStatement = connection.prepareStatement(Queries.SELECT_BY_ID);
			preparedStatement.setInt(1, bookId);

			ResultSet resultSet = preparedStatement.executeQuery();

			Book book = null;

			while (resultSet.next()) {
				book = new Book();
				book.setTitle(resultSet.getString("title"));
				book.setAuthor(resultSet.getString("author"));
				book.setCategory(resultSet.getString("category"));
				book.setBookId(resultSet.getInt("id"));
				book.setPrice(resultSet.getDouble("price"));
			}

			
			return book;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

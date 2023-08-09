package com.bookapp.service;

import java.util.List;

import com.bookapp.client.BookDaoImpl;
import com.bookapp.client.IBookDao;
import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;

public class BookServiceImpl implements IBookService {
	
	IBookDao bookDao = new BookDaoImpl();
	

	@Override
	public List<Book> getAll() {
		List<Book> books =  bookDao.findAll();
		if (books.isEmpty()) {
			throw new BookNotFoundException("No Books were found !");
		}
		return books;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> books =  bookDao.findByCategory(category);
		if (books.isEmpty()) {
			throw new BookNotFoundException("No Books were found !");
		}

		return books;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> books =  bookDao.findByPriceLessThan(price);
		if (books.isEmpty()) {
			throw new BookNotFoundException("No Books were found !");
		}

		return books;

	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		List<Book> books = bookDao.findByAuthorContainsAndCategory(author, category);
		if (books.isEmpty()) {
			throw new BookNotFoundException("No Books were found !");
		}
		return books;
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException {
		Book book =  bookDao.findById(bookId);
		if (book == null) {
			throw new BookNotFoundException("Book with id : " + bookId + ", was not found !");
		}
		return book;

	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
		
	}

	@Override
	public void updateBook(int bookId, double price) {
		bookDao.updateBook(bookId, price);
	}

	@Override
	public void deleteBook(int bookId) {
		bookDao.deleteBook(bookId);
	}

	@Override
	public List<Book> getByAuthorContains(String author) {
		List<Book> books =  bookDao.findByAuthorContains(author);
		if(books.isEmpty()) {
			throw new BookNotFoundException("Books by author was not found !");
		}
		return books;
	}

	

}

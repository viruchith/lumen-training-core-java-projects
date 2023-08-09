package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

public class BookServiceImpl implements IBookService {

	@Override
	public List<Book> getAll() {
		return BookDetails.showBooks().toList();
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> books =  BookDetails.showBooks().filter(book->book.getCategory().toLowerCase().contains(category.toLowerCase())).toList();
		if(books.isEmpty()){
			throw new BookNotFoundException("Books by category '"+category+"' was not found !");
		}
		return books;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> books = BookDetails.showBooks().filter(book->book.getPrice()<price).toList();		
		if(books.isEmpty()) {
			throw new BookNotFoundException("Books less than "+price+" was not found !");
		}
		return books;
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		List<Book> books = BookDetails.showBooks().filter(book->book.getAuthor().toLowerCase().contains(author.toLowerCase()) && book.getCategory().toLowerCase().contains(category.toLowerCase())).toList();		
		if(books.isEmpty()) {
			throw new BookNotFoundException("Books by the author :  '"+author+"' and category :  '"+category+"' was not found !");
		}

		
		return books;
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException {
		return BookDetails.showBooks().filter(book->book.getBookId()==bookId).findFirst().orElseThrow(()->new BookNotFoundException("Books by the bookid :  "+bookId+" was not found !"));
	}

}

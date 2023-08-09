package com.bookapp.service;

import java.util.ArrayList;
import java.util.List;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

public class BookServiceImpl implements IBookService {

	@Override
	public List<Book> getAll() {
		return BookDetails.showBooks();
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		List<Book> books = new ArrayList<Book>();
		for(Book book : BookDetails.showBooks()) {
			if(book.getCategory().toLowerCase().contains(category.toLowerCase())){
				books.add(book);
			}
		}
		
		if(books.size()==0) {
			throw new BookNotFoundException("Books by the category "+category+" was not found !");
		}
		
		return books;
	}

	@Override
	public List<Book> getByPriceLessThan(double price) throws BookNotFoundException {
		List<Book> books = new ArrayList<Book>();
		for(Book book : BookDetails.showBooks()) {
			if(book.getPrice()<price) {
				books.add(book);
			}
		}
		
		if(books.size()==0) {
			throw new BookNotFoundException("Books less than "+price+" was not found !");
		}
		return books;
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		List<Book> books = new ArrayList<Book>();
		for(Book book : BookDetails.showBooks()) {
			if(book.getAuthor().toLowerCase().contains(author.toLowerCase()) && book.getCategory().toLowerCase().contains(category.toLowerCase())){
				books.add(book);
			}
		}
		
		if(books.size()==0) {
			throw new BookNotFoundException("Books by the author :  '"+author+"' and category :  '"+category+"' was not found !");
		}

		
		return books;
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException {
		for(Book book : BookDetails.showBooks()) {
			if(book.getBookId()==bookId) {
				return book;
			}
		}
		
		throw new BookNotFoundException("Books by the bookid :  "+bookId+" was not found !");
	}

}

package com.bookapp.client;

import java.util.List;

import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class BookAppMain {
	public static void main(String[] args) {
		
		
//		BooksPopulator.populate();
				
		IBookService bookService = new BookServiceImpl();
		
		Book book =  bookService.getById(1);		
		System.out.println("Book found by ID : "+book);
		System.out.println();
		
		List<Book> books = bookService.getAll();
		System.out.println("All Books : ");
		books.forEach(System.out::println);
		System.out.println();
		
		
		books = bookService.getByAuthorContains("Blake");
		System.out.println("Books by a author : ");
		books.forEach(System.out::println);
		System.out.println();
		
		books = bookService.getByCategory("Thriller");
		System.out.println("Books by a genre : ");
		books.forEach(System.out::println);
		System.out.println();
		
		books = bookService.getByPriceLessThan(200);
		System.out.println("Books by price less than : ");
		books.forEach(System.out::println);
		System.out.println();
		
		books = bookService.getByAuthorContainsAndCategory("Chetan","Romance");
		System.out.println("Books by author and category : ");
		books.forEach(System.out::println);
		System.out.println();
		
		
		book =  bookService.getById(3);		
		System.out.println("Before update: "+book);
		bookService.updateBook(book.getBookId(), book.getPrice()+100);
		System.out.println();
		book =  bookService.getById(3);		
		System.out.println("After update : "+book);
		
		


	
	}
}

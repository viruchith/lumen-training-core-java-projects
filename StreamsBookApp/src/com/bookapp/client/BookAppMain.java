package com.bookapp.client;

import java.util.Iterator;
import java.util.List;

import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;

public class BookAppMain {
	public static void main(String[] args) {
		IBookService bookService = new BookServiceImpl();
		
		System.out.println("Books by category");
		List<Book> booksByCategory =  bookService.getByCategory("Sci-Fi");
		booksByCategory.forEach(System.out::println);
		System.out.println();
		
		System.out.println("Books by category");
		List<Book> booksByPriceLessThan =  bookService.getByPriceLessThan(300);
		booksByPriceLessThan.forEach(System.out::println);
		System.out.println();	
		
		
		
		System.out.println("Books by Author and Category");
		List<Book> booksByAuthorAndCategory =  bookService.getByAuthorContainsAndCategory("Chetan Bhagat","Romance");
		booksByAuthorAndCategory.forEach(System.out::println);
		System.out.println();
		
		
		System.out.println("Books by Id");
		System.out.println("Book by ID : "+bookService.getById(108));
	
	}
}

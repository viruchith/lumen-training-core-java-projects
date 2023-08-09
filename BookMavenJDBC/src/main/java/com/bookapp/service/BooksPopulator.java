package com.bookapp.service;

import java.util.Arrays;
import java.util.List;

import com.bookapp.client.BookDaoImpl;
import com.bookapp.client.IBookDao;
import com.bookapp.model.Book;

public class BooksPopulator {
	public static void populate() {
		List<Book> books = Arrays.asList(
				new Book("Dark Matter", "Blake Crouch", "Sci-Fi", 101, 599.0),
				new Book("And then there were None","Mystery"," Agatha Christie",102,199.0),
				new Book("Wayward Pines", "Blake Crouch","Sci-Fi", 103, 399.0),
				new Book("Recursion", "Blake Crouch","Sci-Fi", 104, 299.0),
				new Book("Half Girlfriend", "Chetan Bhagat","Romance", 105, 399.0),
				new Book("Revolution 2020", "Chetan Bhagat","Romance", 106, 399.0),
				new Book("Anxious People", "Fredrick Backman","Philosophy", 107, 399.0),
				new Book("The Key to Rebecca", "Ken Follet","Thriller", 108, 399.0),
				new Book("It ends with us","Colleen Hoover","Romance",109,299.0),
				new Book("The Alchemist","Paulo Coelho","Philosophy",110,99.0),
				new Book("Davinci code","Dan Brown","Thriller",111,199.0),
				new Book("The flight of the old dog","Dale Brown","Action",112,259.0),
				new Book("Three mistakes of my life","Chetan Bhagat","Drama",113,199.0),
				new Book("As the crow flies","Jeffrey Archer","Drama",114,399.0),
				new Book("The second lady","Irving Wallace","Thriller",115,299.0)
				);
		
		IBookDao bookDao = new BookDaoImpl();
		
		for (Book book : books) {
			bookDao.addBook(book);
		}
	}
}

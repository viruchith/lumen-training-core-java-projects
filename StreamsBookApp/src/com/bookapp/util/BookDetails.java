package com.bookapp.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.bookapp.model.Book;

public class BookDetails {
	public static Stream<Book> showBooks(){
		return Stream.of(
				new Book("Dark Matter", "Blake Crouch", "Sci-Fi", 101, 599.0),
				new Book("And then there were None","Mystery"," Agatha Christie",102,199.0),
				new Book("Wayward Pines", "Blake Crouch","Sci-Fi", 103, 399.0),
				new Book("Recursion", "Blake Crouch","Sci-Fi", 104, 299.0),
				new Book("Half Girlfriend", "Chetan Bhagat","Romance", 105, 399.0),
				new Book("Revolution 2020", "Chetan Bhagat","Romance", 106, 399.0),
				new Book("Anxious People", "Fredrick Backman","Philosophy", 107, 399.0),
				new Book("The Key to Rebecca", "Ken Follet","Thriller", 108, 399.0)
				);
	}
}

package com.bookapp.model;

public class Book {
	private String title;
	private String author;
	private Integer bookId;
	private Double price;
	private String category;
	
	public Book() {
	}

	public Book(String title, String author,String category , Integer bookId, Double price) {
		super();
		this.title = title;
		this.author = author;
		this.bookId = bookId;
		this.category = category;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", bookId=" + bookId + ", price=" + price + "]";
	}
	
}

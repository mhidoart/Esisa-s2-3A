package com.esisa.jee.models;

public class Document {
	private String isbn;
	private String title;
	private int yearPublished;
	
	public Document() {
		super();
	}

	public Document(String isbn, String title, int yearPublished) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.yearPublished = yearPublished;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	@Override
	public String toString() {
		return "Document [isbn=" + isbn + ", title=" + title + ", yearPublished=" + yearPublished + "]";
	}
	
	
}

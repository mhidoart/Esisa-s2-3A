package com.esisa.java.reflexion.model;

import com.esisa.java.reflexion.annotations.Form;
import com.esisa.java.reflexion.annotations.Textfield;

@Form(title="Nouveau doc")
public class Document {
	@Textfield(label="ISBN")
	private String isbn;
	@Textfield(label="Titre",size=40)
	private String title;
	@Textfield(label="Prix unitaire ",size=10)
	private double price;
	private int publisherid;
	public Document() {
		// TODO Auto-generated constructor stub
	}
	public Document(String isbn, String title, double price, int publisherid) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.publisherid = publisherid;
	}
	public String getIsbn() {
		return isbn;
	}
	public void print() {
		System.out.println(this);
	}
	public void print(String msg , int index) {
		System.out.println(index +"   " +msg +" ( "+isbn+", " + title+", "+price+", " + publisherid+" )");
	}
	@Override
	public String toString() {
		return "Document [isbn=" + isbn + ", title=" + title + ", price=" + price + ", publisherid=" + publisherid
				+ "]";
	}
	
}

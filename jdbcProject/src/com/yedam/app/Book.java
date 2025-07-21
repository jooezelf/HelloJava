package com.yedam.app;

public class Book {
	private int id;
	private String title;
	private String author;
	private int price;

	//생성자
	public Book(int id, String title, String author, int price) {
		super(); //부모클래스
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
public Book() {
		// TODO Auto-generated constructor stub
	}

	// getter, setter 생성.
	public static int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public static int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setPrice(String string) {
		// TODO Auto-generated method stub
		
	}
	

}

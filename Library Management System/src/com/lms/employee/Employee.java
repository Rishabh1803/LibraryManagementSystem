package com.lms.employee;

import com.lms.book.Book;

public class Employee {
	private Book book;
	private String name;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee(Book book, String name) {
		super();
		this.book = book;
		this.name = name;
	}
	public Employee() {
	}
	@Override
	public String toString() {
		return name + "\t" + book.toString() + "\t" + book.getIssueDate() + "\t" + book.getReturnDate() + "\t" + book.getFine();
	}
	public String fineMessage() {
		if(book.getFine() == 0)
			return "There is no late fee applicable and the book has been returned";
		else
			return null;
	}
}
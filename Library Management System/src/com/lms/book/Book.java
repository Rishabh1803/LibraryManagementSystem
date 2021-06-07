package com.lms.book;

import java.time.LocalDate;

public abstract class Book {
	
	private static final byte issueDuration = 7;
	private int lateFee;
	private int stock;
	private LocalDate issueDate;
	private LocalDate returnDate;
	
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate2) {
		this.issueDate = issueDate2;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public static byte getIssueduration() {
		return issueDuration;
	}
	public int getLateFee() {
		return lateFee;
	}
	public void setLateFee(int lateFee) {
		this.lateFee = lateFee;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Book() {
	}
	
	public Book(int lateFee, int stock, LocalDate issueDate) {
		super();
		this.lateFee = lateFee;
		this.stock = stock;
		this.issueDate = issueDate;
		returnDate = LocalDate.now();
	}
	abstract public int getFine(); 
}
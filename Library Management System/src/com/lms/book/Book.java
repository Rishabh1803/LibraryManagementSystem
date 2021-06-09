package com.lms.book;

public class Book {
	
	private static final byte issueDuration = 7;
	private int lateFee;
	private int bookId;
	private int stocks;
	private String bookName;
	
	public int getStocks() {
		return stocks;
	}
	public void setStocks(int stocks) {
		this.stocks = stocks;
	}
	public int getLateFee() {
		return lateFee;
	}
	public void setLateFee(int lateFee) {
		this.lateFee = lateFee;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public static byte getIssueduration() {
		return issueDuration;
	}
	public Book(int lateFee, int bookId, int stocks, String bookName) {
		super();
		this.lateFee = lateFee;
		this.bookId = bookId;
		this.stocks = stocks;
		this.bookName = bookName;
	}
	public Book() {
	}
	@Override
	public String toString() {
		return bookId + ".\t" + bookName;
	}
	
}
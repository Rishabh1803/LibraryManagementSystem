package com.lms.book;

import java.time.LocalDate;
import java.time.Period;

public class DataAnalyticsBook extends Book {
	private int period;
	public DataAnalyticsBook(int stock, LocalDate issueDate) {
		setLateFee(5);
		setStock(stock);
		setIssueDate(issueDate);
		setReturnDate(LocalDate.now());
	}
	public DataAnalyticsBook() {
		setLateFee(5);
		setReturnDate(LocalDate.now());
	}
	
	@Override
	public String toString() {
		return "Data Analytics Book";
	}

	@Override
	public int getFine() {
		period = Period.between(getIssueDate(),getReturnDate()).getDays() - 7;
		return period * getLateFee();
	}
}
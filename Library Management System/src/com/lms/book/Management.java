package com.lms.book;

import java.time.LocalDate;
import java.time.Period;

public class Management extends Book {
	private int period;
	public Management(int stock, LocalDate issueDate) {
		setLateFee(7);
		setStock(stock);
		setIssueDate(issueDate);
	}
	public Management() {
		setReturnDate(LocalDate.now());
	}
	@Override
	public String toString() {
		return "Management";
	}
	
	@Override
	public int getFine() {
		period = Period.between(getReturnDate(), getIssueDate()).getDays();
		if(period > getIssueduration())
			return (period-getIssueduration()) * getLateFee();
		else
			return 0;
	}
}
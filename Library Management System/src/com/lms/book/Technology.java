package com.lms.book;

import java.time.LocalDate;
import java.time.Period;

public class Technology extends Book {
	@Override
	public String toString() {
		return "Technology";
	}
	private int period;
	public Technology(int stock, LocalDate issueDate) {
		setLateFee(6);
		setStock(stock);
		setIssueDate(issueDate);
	}
	public Technology() {
		setReturnDate(LocalDate.now());
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
package com.lms.employee;

import java.time.LocalDate;

public class Employee {
	@Override
	public String toString() {
		return name + "\t" + issueDate + "\t" + bookId;
	}
	public String name;
	public LocalDate issueDate;
	public int bookId;
	public Employee(){
	}
	public Employee(String name, LocalDate date,int bookId){
		this.name=name;
		this.issueDate=date;
		this.bookId=bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
}
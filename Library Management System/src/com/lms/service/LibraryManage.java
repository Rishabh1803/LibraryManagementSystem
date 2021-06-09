package com.lms.service;

import java.time.LocalDate;
import java.util.Collection;

import com.lms.book.Book;
import com.lms.employee.Employee;

public interface LibraryManage {
	boolean returnBook(String name, int id) throws Exception;
	boolean issueBook(String name, int id) throws Exception;
	Collection<Employee> getAllIssuedBooks(String name) throws Exception;
	int getFine(String name, int id)throws Exception;
	boolean checkAvailability(int id) throws Exception;
	Collection<Book> getAllBooks() throws Exception;
	LocalDate getIssueDate(String name, int id)throws Exception;
}
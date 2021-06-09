package com.lms.persistence;

import java.time.LocalDate;
import java.util.Collection;

import com.lms.book.Book;
import com.lms.employee.Employee;

public interface LibraryManagementSystemDAO {
	boolean issueBook(String name, int id) throws Exception;
	boolean returnBook(String name, int id) throws Exception;
	Collection<Employee> getAllIssuedBooks(String name) throws Exception;
	LocalDate getIssueDate(String name, int id) throws Exception;
	Collection<Book> getAllBooks() throws Exception;
	boolean isAvailable(int id)throws Exception;
	int getLateFee(int id) throws Exception;
}

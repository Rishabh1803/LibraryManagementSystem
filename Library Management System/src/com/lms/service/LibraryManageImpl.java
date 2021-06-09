package com.lms.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;

import com.lms.book.Book;
import com.lms.employee.Employee;
import com.lms.persistence.LibraryManagementSystemDaoImp;

public class LibraryManageImpl implements LibraryManage {
	
	LibraryManagementSystemDaoImp manager = new LibraryManagementSystemDaoImp();
	@Override
	public boolean returnBook(String name, int id) throws Exception {
		return manager.returnBook(name, id);
	}

	@Override
	public boolean issueBook(String name, int id) throws Exception {
		return manager.issueBook(name, id);
	}

	@Override
	public Collection<Employee> getAllIssuedBooks(String name) throws Exception {
		return manager.getAllIssuedBooks(name);
	}

	@Override
	public int getFine(String name, int id) throws Exception {
		int lateFee = manager.getLateFee(id);
		int fine = (Period.between(LocalDate.now(), manager.getIssueDate(name, id)).getDays() - Book.getIssueduration())* lateFee;
		return fine;
	}

	@Override
	public boolean checkAvailability(int id) throws Exception {
		return manager.isAvailable(id);
	}

	@Override
	public Collection<Book> getAllBooks() throws Exception {
		return manager.getAllBooks();
	}

	@Override
	public LocalDate getIssueDate(String name, int id) throws Exception {
		return manager.getIssueDate(name, id);
	}

}

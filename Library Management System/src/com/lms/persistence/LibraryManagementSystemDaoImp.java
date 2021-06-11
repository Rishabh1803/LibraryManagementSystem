package com.lms.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;

import com.lms.book.Book;
import com.lms.employee.Employee;
import com.lms.helper.MySQLConnection;

public class LibraryManagementSystemDaoImp implements LibraryManagementSystemDAO {

	@Override
	public boolean issueBook(String name, int id) throws Exception {
		Connection connection = MySQLConnection.makeConnection();
		PreparedStatement statementEmp = connection.prepareStatement("insert into Employee values (?,?,?)");
		Date date = Date.valueOf(LocalDate.now());
		statementEmp.setString(1, name);
		statementEmp.setInt(2, id);
		statementEmp.setDate(3,date);
		int rowsEmployee = statementEmp.executeUpdate();
		PreparedStatement statementBook = connection.prepareStatement("update Book set stock = (stock - 1) where BookId = ?");
		statementBook.setInt(1, id);
		int rowsBook = statementBook.executeUpdate();
		connection.close();
		if(rowsBook == rowsEmployee)
			return true;
		return false;
	}

	@Override
	public boolean returnBook(String name, int id) throws Exception {
		Connection connection = MySQLConnection.makeConnection();
		PreparedStatement statementEmp = connection.prepareStatement("delete from Employee where EmployeeName = ? and BookId = ?");
		statementEmp.setString(1,name);
		statementEmp.setInt(2,id);
		int rowsEmployee = statementEmp.executeUpdate();
		PreparedStatement statementBook = connection.prepareStatement("update Book set stock = stock + 1 where BookId = ?");
		statementBook.setInt(1, id);
		statementBook.executeUpdate();
		connection.close();
		if(rowsEmployee > 0)
			return true;
		return false;
	}
	@Override
	public LocalDate getIssueDate(String name, int id) throws Exception{
		LocalDate date = null;
		Connection connection = MySQLConnection.makeConnection();
		PreparedStatement statement = connection.prepareStatement("select IssueDate from Employee where EmployeeName = ? and BookId = ?");
		statement.setString(1, name);
		statement.setInt(2, id);
		ResultSet set = statement.executeQuery();
		set.next();
		String datesql = set.getString(1);
		date = LocalDate.parse(datesql);
		connection.close();
		return date;
	}

	@Override
	public Collection<Employee> getAllIssuedBooks(String name) throws Exception {
		Collection<Employee> employees;
		employees = new ArrayList<Employee>();
		Connection connection = MySQLConnection.makeConnection();
		PreparedStatement statementEmp = connection.prepareStatement("select * from Employee where EmployeeName = ?");
		statementEmp.setString(1, name);
		ResultSet s = statementEmp.executeQuery();
		boolean flag = false;
		while(s.next()) {
			Employee employee = new Employee();
			employee.setName(s.getString(1));
			employee.setBookId(s.getInt(2));
			employee.setIssueDate(LocalDate.parse(s.getDate(3).toString()));
			employees.add(employee);
			flag = true;
		}
		connection.close();
		if(flag)
			return employees;
		else
			return null;
	}

	@Override
	public Collection<Book> getAllBooks() throws Exception {
		Connection connection = MySQLConnection.makeConnection();
		PreparedStatement statement = connection.prepareStatement("select * from Book");
		ResultSet set = statement.executeQuery();
		Collection<Book> books;
		books = new ArrayList<Book>();
		while(set.next()) {
			Book book = new Book();
			book.setBookId(set.getInt(1));
			book.setBookName(set.getString(2));
			book.setStocks(set.getInt(3));
			book.setLateFee(set.getInt(4));
			books.add(book);
		}
		connection.close();
		return books;
	}

	@Override
	public boolean isAvailable(int id) throws Exception {
		Connection connection = MySQLConnection.makeConnection();
		PreparedStatement statement = connection.prepareStatement("select stock from Book where BookId = ?");
		statement.setInt(1, id);
		ResultSet set = statement.executeQuery();
		set.next();
		int stock = set.getInt(1);
		connection.close();
		if(stock>0)
			return true;
		return false;
	}

	@Override
	public int getLateFee(int id) throws Exception {
		Connection connection = MySQLConnection.makeConnection();
		PreparedStatement statement = connection.prepareStatement("select lateFee from Book where BookId = ?");
		statement.setInt(1, id);
		ResultSet set = statement.executeQuery();
		int lateFee = 0;
		if(set.next()) {
			lateFee = set.getInt("lateFee");
		}
		connection.close();
		return lateFee;
	}
}
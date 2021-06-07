package com.lms.presentation;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.lms.book.DataAnalyticsBook;
import com.lms.book.Management;
import com.lms.book.Technology;
import com.lms.employee.Employee;

public class PresentationImpl implements Presentation {
	
	private Employee employee = new Employee();
	Scanner sc = new Scanner(System.in); 
	@Override
	public void showMenu() {
		System.out.println("Welcome to the Library Management System!\n");
		System.out.println("1. Issue a Book");
		System.out.println("2. Return a Book");
		System.out.print("\nEnter your choice: ");
	}
	public void showBook() {
		System.out.println("\n1. Data Analytics");
		System.out.println("2. Technology");
		System.out.println("3. Management");
		System.out.print("Enter your choice: ");
	}
	
	public void setEmployee(int choice) {
		switch(choice) {
		case 1: employee.setBook(new DataAnalyticsBook());
		break;
		case 2: employee.setBook(new Technology());
		break;
		case 3: employee.setBook(new Management());
		}
	}

	@Override
	public void performMenu(int choice) {
		switch(choice) {
		case 1: showBook();
				setEmployee(sc.nextInt());
				break;
		case 2: System.out.print("Enter Name: ");
				employee.setName(sc.nextLine());
				showBook();
				setEmployee(sc.nextInt());
				StringTokenizer s =new  StringTokenizer(sc.next(),"-");
				employee.getBook().setIssueDate(LocalDate.of(Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken()),Integer.parseInt(s.nextToken())));
				employee.getBook().setReturnDate(LocalDate.now());
				employee.fineMessage();
				System.out.println(employee);
		}

	}

}

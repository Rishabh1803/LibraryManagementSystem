package com.lms.presentation;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;
import com.lms.book.Book;
import com.lms.employee.Employee;
import com.lms.service.LibraryManageImpl;

public class PresentationImpl implements Presentation {

	Scanner sc = new Scanner(System.in);
	LibraryManageImpl manager = new LibraryManageImpl();
	@Override
	public void showMenu() {
		System.out.println("================================");
		System.out.println("1. Issue a Book");
		System.out.println("2. Return a Book");
		System.out.println("3. Get all books issued by Employee");
		System.out.println("4. Exit");
		System.out.println("================================");
		System.out.print("Enter your choice: ");
	}

	@Override
	public void showAvailableBooks(){
		try {
			System.out.println("=============================================");
			System.out.println("Available Books");
			System.out.println("---------------------------------------------");
			for(Book b : manager.getAllBooks())
				System.out.println(b);
			System.out.println("=============================================");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void performMenu(int choice) {
		conditional:
			switch(choice) {
			case 1: showAvailableBooks();
					try {
						System.out.print("\nEnter Book Id: ");
						int id = sc.nextInt();
						if(!manager.checkAvailability(id)) {
							System.out.println("Not Available!\n Try Again!!");
							break conditional;
						}
						sc.nextLine();
						System.out.print("Enter name of Employee: ");
						String nameIssue = sc.nextLine();
						if(manager.issueBook(nameIssue,id))
							System.out.println("Issued Successfully!\n");
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
			case 2: showAvailableBooks();
					System.out.print("\nEnter the Book Id: ");
					int Id = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter Name of Employee: ");
					String nameReturn = sc.nextLine();
					int fine = 0;
					try {
						fine = manager.getFine(nameReturn, Id);
						if(manager.returnBook(nameReturn, Id))
							System.out.println("\nBook Returned Successfully");
						else {
							System.out.println("ERROR 404! Record Not Found!!");
							break conditional;
						}
						if(fine == 0) {
							System.out.println("No Fine is applicable as the book was returned on time");
						}
						System.out.println("=============================================");
						System.out.println("Name of Employee: "+nameReturn);
						System.out.println("Book Id: " + Id);
						System.out.println("Return Date: " + LocalDate.now());
						System.out.println("Fine: " + fine);
						System.out.println("=============================================");
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
			case 3: System.out.print("\nEnter name of the employee: ");
					String name = sc.nextLine();
					try {
						Collection<Employee> employees = manager.getAllIssuedBooks(name);
						System.out.println();
						if(employees == null)
							System.out.println("No Record Found!!");
						else {
							System.out.println("=============================================");
							for(Employee emp:employees)
								System.out.println(emp);
							System.out.println("=============================================");
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					break;
			case 4: System.out.println("================================================================");
					System.out.println("Thank you for using Library Management System");
					System.out.println("This system was designed by Rishabh Khare and Sai Sankeerthana!");
					System.out.println("Do use again!");
					System.out.println("Contact owner if you face an error!");
					System.out.println("================================================================");
					System.exit(0);
					break;
			default: System.out.println("Invalid Choice!!\nPlease enter again");
			}
	}
}
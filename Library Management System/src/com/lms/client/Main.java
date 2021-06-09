package com.lms.client;

import java.util.Scanner;

import com.lms.presentation.PresentationImpl;

public class Main {
	static {
		System.out.println("Welcome to the Library Management System!");
	}
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PresentationImpl present = new PresentationImpl();
		while(true) {
			present.showMenu();
			present.performMenu(sc.nextInt());
		}
	}
}
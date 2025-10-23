package com.cisco;

import java.util.Scanner;

public class TestUsers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of users you want to store");
		int size = scan.nextInt();
		// initialize the array
		User[] users = new User[size];
		for(int i = 0; i < size; i++) {
			System.out.println("Enter userid");
			int id = scan.nextInt();
			System.out.println("Enter username");
			String username = scan.next();
			System.out.println("Enter password");
			String password = scan.next();
			System.out.println("Enter age");
			int age = scan.nextInt();
			User user = new User(id, username, password, age);
			users[i] = user;
		}
		for(User user : users) {
			System.out.println("Name = "+user.getUsername());
		}
		scan.close();
	}
}
package com.cisco;

import java.util.Scanner;
/*
 * Use the same program and take inputs for double, boolean, float
 */
public class TestScanner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name:-");
		String name = scan.next();
		System.out.println("Enter full name:-");
		scan.nextLine();
		String fullname = scan.nextLine();
		System.out.println("Enter your phone no:-");
		long phone = scan.nextLong();
		System.out.println("Hello "+name+", Fullname = "+fullname+", Phone = "+phone);
		scan.close();
	}
}
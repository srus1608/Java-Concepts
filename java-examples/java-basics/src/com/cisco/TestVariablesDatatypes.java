package com.cisco;
/*
 * Size of each type - only for primitives the size is fixed
 * byte - 1, short - 2, int - 4, long - 8, float - 4, double - 8
 * char - 2, boolean - unspecified 
 */
public class TestVariablesDatatypes {
	public static void main(String[] args) {
		String username = "Ajay"; // derived type - use double quotes for String
		int age = 21; // primitive types
		char gender = 'M'; // use single quote for char
		double salary = 56000.40; 
		boolean isEmployed = true;
		System.out.println("Username = "+username);
		System.out.println("Age = "+age+", Gender = "+gender);
		System.out.println("Salary = "+salary+", Is Employed = "+isEmployed);
	}
}
package com.cisco;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestEmployeeCollection {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Employee> employees = new ArrayList<Employee>();
		System.out.println("How many employees would you like to store");
		int size = scan.nextInt();
		for(int i = 0; i < size; i++) {
			System.out.println("Enter id");
			int id = scan.nextInt();
			System.out.println("Enter name");
			String name = scan.next();
			System.out.println("Enter DOB in yyyy-MM-dd format");
			LocalDate dob = LocalDate.parse(scan.next());
			System.out.println("Enter salary");
			double salary = scan.nextDouble();
			Employee employee = new Employee(id, name, dob, salary);
			employees.add(employee);
		}
		printEmployees(employees);
		scan.close();
	}

	private static void printEmployees(List<Employee> employees) {
		for(Employee e : employees) {
			System.out.println(e);
		}
	}
}
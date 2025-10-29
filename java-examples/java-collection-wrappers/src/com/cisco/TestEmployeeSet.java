package com.cisco;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class TestEmployeeSet {

	public static void main(String[] args) {
		Set<Employee> employees = new HashSet<Employee>();

		Employee emp1 = new Employee(100, "Raj", LocalDate.parse("2000-10-10"), 45000);
		Employee emp2 = new Employee(102, "Vijay", LocalDate.parse("2001-10-10"), 55000);
		Employee emp3 = new Employee(103, "Manoj", LocalDate.parse("2002-10-10"), 65000);
		Employee emp4 = new Employee(102, "Vijay", LocalDate.parse("2001-10-10"), 55000);
		Employee emp5 = new Employee(100, "Raj", LocalDate.parse("2000-10-10"), 45000);

		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		printEmployees(employees);
	}
	public static void printEmployees(Set<Employee> set) {
		System.out.println("Size of set = "+set.size());
		for(Employee e : set) {
			System.out.println(e);
		}
		System.out.println("_________________________________________");
	}

}
package com.cisco;

import java.time.LocalDate;

public class Employee {
	private int id;
	private String name;
	private LocalDate dob;
	private double salary;
	
	public Employee(int id, String name, LocalDate dob, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dob=" + dob + ", salary=" + salary + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
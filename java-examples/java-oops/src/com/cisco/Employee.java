package com.cisco;

public class Employee extends Person {
	private int id;
	private double salary;
	
	public Employee(int id, String name, long phone, double salary) {
		super(name, phone); // Person(String, long)
		this.id = id;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void displayInfo() {
        super.displayInfo(); // Call parent's displayInfo
        System.out.println("Employee ID: " + id + ", Salary: $" + salary);
    }
}
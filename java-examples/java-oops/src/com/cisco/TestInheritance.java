package com.cisco;

public class TestInheritance {
	public static void main(String[] args) {
		Employee employee1 = new Employee(123, "Kishor", 9393932, 40000);
		employee1.setName("Sachin");
		System.out.println("Id = "+employee1.getId()+", Name = "+employee1.getName());
	}
}
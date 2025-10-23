package com.cisco;

public class TestStudent {
	public static void main(String[] args) {
		Student student1 = new Student(123, "Raj", "raj@g");
		Student student2 = new Student(456, "Vijay", "vijay@g");
		student1.setEmail("raj@gmail.com");
		String student1Details = student1.getStudentDetails();
		String student2Details = student2.getStudentDetails();
		System.out.println(student1Details);
		System.out.println(student2Details);
		System.out.println("Hello "+student1.getName());
		Student.university = "XYZ";
		student1.university = "1234";
		student2.university = "88899";
		System.out.println("Univeristy = "+Student.university);;
		System.out.println("Univeristy = "+student1.university);;
		System.out.println("Univeristy = "+student2.university);
	}
}
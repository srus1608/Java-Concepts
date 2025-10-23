package com.cisco;

public class Student {
	// instance variables
	private int rollNo;
	private String name;
	private String email;
	
	// static variables
	static String university = "ABC University";
	
	// constructor - default won't be created when you explicitly create the constructor
	Student(int rollNo, String name, String emailId) {
		this.rollNo = rollNo;
		this.name = name;
		email = emailId;
	}
	// setter for name and email
	public void setName(String name) { 
		this.name = name; 
	} 
	public void setEmail(String email) { 
		this.email = email; 
	} 
	public int getRollNo() { 
		return rollNo;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getStudentDetails() {
		return "RollNo="+rollNo+",Name="+name+",Email="+email;
	}
}
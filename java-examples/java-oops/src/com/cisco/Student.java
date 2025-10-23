package com.cisco;



public class Student extends Person { // Student inherits from Person
    private String studentId;
    private String major;

    public Student(String studentId, String name, long phone, String major) {
        super(name, phone); // Call the constructor of the parent class (Person)
        this.studentId = studentId;
        this.major = major;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId + ", Major: " + major);
    }
}
package com.cisco;

public class Manager extends Employee { // Manager inherits from Employee
    private String department;

    public Manager(int id, String name, long phone, double salary, String department) {
        super(id, name, phone, salary); // Call the constructor of the parent class (Employee)
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Manager Department: " + department);
    }
}
package com.cisco;

public class Programmer extends Employee { // Programmer inherits from Employee
    private String programmingLanguage;

    public Programmer(int id, String name, long phone, double salary, String programmingLanguage) {
        super(id, name, phone, salary); // Call the constructor of the parent class (Employee)
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Programmer Language: " + programmingLanguage);
    }
}
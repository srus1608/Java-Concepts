package com.cisco;

public class HierarchyTest {

    public static void main(String[] args) {
        System.out.println("--- Creating Objects ---");

        // Create a Person
        Person p1 = new Person("Alice", 9876543210L);
        p1.displayInfo();
        System.out.println("--------------------");

        // Create a Customer
        Customer cust1 = new Customer("CUST123", "Bob", 1122334455L);
        cust1.displayInfo();
        System.out.println("--------------------");

        // Create an Employee
        Employee emp1 = new Employee(101, "Charlie", 2233445566L, 75000.00);
        emp1.displayInfo();
        System.out.println("--------------------");

        // Create a Student
        Student s1 = new Student("STU789", "Diana", 3344556677L, "Computer Science");
        s1.displayInfo();
        System.out.println("--------------------");

        // Create a CorporateCustomer
        CorporateCustomer corpCust1 = new CorporateCustomer("CORP001", "Eve", 4455667788L, "Tech Solutions Inc.");
        corpCust1.displayInfo();
        System.out.println("--------------------");

        // Create a RegularCustomer
        RegularCustomer regCust1 = new RegularCustomer("REG001", "Frank", 5566778899L, "Gold");
        regCust1.displayInfo();
        System.out.println("--------------------");

        // Create a Manager
        Manager mgr1 = new Manager(201, "Grace", 6677889900L, 120000.00, "Engineering");
        mgr1.displayInfo();
        System.out.println("--------------------");

        // Create a Programmer
        Programmer prog1 = new Programmer(301, "Heidi", 7788990011L, 90000.00, "Java");
        prog1.displayInfo();
        System.out.println("--------------------");

        System.out.println("\n--- Demonstrating Polymorphism ---");
        // You can store objects of subclasses in variables of their superclass type
        Person genericPerson1 = new Customer("GCUST001", "Ivan", 8899001122L);
        genericPerson1.displayInfo(); // Calls Customer's displayInfo due to polymorphism
        System.out.println("--------------------");

        Person genericPerson2 = new Manager(401, "Judy", 9900112233L, 150000.00, "HR");
        genericPerson2.displayInfo(); // Calls Manager's displayInfo
        System.out.println("--------------------");
    }
}
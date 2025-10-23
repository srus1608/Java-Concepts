package com.cisco;

// Interface defining common behaviors for vehicles
interface Vehicle {
    void milage(); // Method to get mileage information
    void wheels(); // Method to get wheel count information
}

// Abstract class Car implements Vehicle, providing a common wheels implementation
// but leaving milage() for its concrete subclasses.
abstract class Car implements Vehicle {
    @Override 
    public void wheels() {
        System.out.println("This is a 4-wheeler.");
    }
    // milage() is not implemented here, so Car must be abstract.
    // Concrete subclasses will implement it.
}

// Concrete class Nexon extends Car and implements its specific milage
class Nexon extends Car {
    @Override // Implementing the abstract milage method from Vehicle (via Car)
    public void milage() {
        System.out.println("Nexon mileage is 18kmpl------------");
    }
}

// Concrete class Brezza extends Car and implements its specific milage
class Brezza extends Car {
    @Override // Implementing the abstract milage method from Vehicle (via Car)
    public void milage() {
        System.out.println("-------Brezza mileage is 20kmpl-------------");
    }
}

// ---  BIKE ACTIVITY---

// Abstract class Bike implements Vehicle, providing a common wheels implementation
// but leaving milage() for its concrete subclasses.
// It must be abstract because it doesn't implement 'milage()' itself.
abstract class Bike implements Vehicle {
    @Override // Corrected annotation casing
    public void wheels() {
        System.out.println("This is a 2-wheeler.");
    }
    // milage() is not implemented here, so Bike must be abstract.
    // Concrete subclasses will implement it.
}

class Honda extends Bike {
    @Override 
    public void milage() {
        System.out.println("Honda bike mileage is 60kmpl.");
    }
}

// Second subclass of Bike: Bullet
class Bullet extends Bike {
    @Override 
    public void milage() {
        System.out.println("Bullet bike mileage is 35kmpl.");
    }
}



public class TestAbstraction {
    // A generic print method that can accept any object implementing the Vehicle interface
    public static void print(Vehicle v) {
        v.milage(); 
        v.wheels(); 
        System.out.println("--------------------");
    }

    public static void main(String[] args) {
        // Car examples
        Nexon nexon = new Nexon();
        Brezza breeza = new Brezza();

        print(nexon);
        print(breeza);

        // Bike examples (from the activity)
        Honda honda = new Honda();
        Bullet bullet = new Bullet();

        print(honda); 
        print(bullet); 
    }
}
package com.cisco;

public class RegularCustomer extends Customer { // RegularCustomer inherits from Customer
    private String loyaltyProgramLevel;

    public RegularCustomer(String customerId, String name, long phone, String loyaltyProgramLevel) {
        super(customerId, name, phone); // Call the constructor of the parent class (Customer)
        this.loyaltyProgramLevel = loyaltyProgramLevel;
    }

    public String getLoyaltyProgramLevel() {
        return loyaltyProgramLevel;
    }

    public void setLoyaltyProgramLevel(String loyaltyProgramLevel) {
        this.loyaltyProgramLevel = loyaltyProgramLevel;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Regular Customer Loyalty Level: " + loyaltyProgramLevel);
    }
}
package com.cisco;

public class CorporateCustomer extends Customer { // CorporateCustomer inherits from Customer
    private String companyName;

    public CorporateCustomer(String customerId, String name, long phone, String companyName) {
        super(customerId, name, phone); // Call the constructor of the parent class (Customer)
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Corporate Customer Company: " + companyName);
    }
}
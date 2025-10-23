package com.cisco;


public class BaseObject {
    private String id;

    public BaseObject(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("BaseObject ID: " + id);
    }
}
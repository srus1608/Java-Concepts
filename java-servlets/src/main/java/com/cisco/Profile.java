package com.cisco;

public class Profile {
    private int id;
    private String name;
    private String dob; 

    public Profile(int id, String name, String dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Profile [ID=" + id + ", Name=" + name + ", Date of Birth=" + dob + "]";
    }
}
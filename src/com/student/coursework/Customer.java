package com.student.coursework;

// Programming and Program Design
// Student Number: 18023219

public class Customer {
    private String name = "";

    public Customer(String name){ // customer constructor requires string parameter to set name
        this.setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){return this.name;} // Get the name of the current customer object




}

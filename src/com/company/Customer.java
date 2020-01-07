package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private String name = "";
    public static ArrayList<String> customerList = new ArrayList<String>(); // Create an ArrayList object to store all of the customers

    public Customer(String input){ // customer constructor requires string parameter to set name
        this.setName(input);
    }

    public void setName(String name) {
        this.name = name;
        customerList.add(name);
    }

    public String getName(){return this.name;} // Get the name of the current customer object


    public static void login() {
        System.out.println("Welcome to the ETC Lesson booking program");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter your username to continue");
        String userName = myObj.nextLine();  // Read user input
        Customer currentUser = new Customer(userName); // Create new customer object
        System.out.println("Logged in user is: " + currentUser.getName() );  // Confirm logged in & output user input

    }


}

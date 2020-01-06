package com.company;

import java.util.Scanner;

public class Customer {
    private String name = "";

    public Customer(String input){
        this.setName(input);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){return this.name;}

    public static void login() {
        System.out.println("Welcome to the class booking program");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter your username to continue");
        String userName = myObj.nextLine();  // Read user input
        Customer newUser = new Customer(userName); // Create new customer object
        System.out.println("Logged in user is: " + userName);  // Confirm logged in & output user input
    }


}

package com.company;

import java.util.Scanner;

public class Customer {

    static String login() {
        System.out.println("Welcome to the class booking program");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter your username to continue");
        String userName = myObj.nextLine();  // Read user input
        System.out.println("Username is: " + userName);  // Output user input
        return userName;
    }


}

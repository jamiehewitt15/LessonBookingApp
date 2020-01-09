package com.company;

import java.util.HashMap; // import the HashMap class
import java.util.Scanner;

import static com.company.DataValidator.dataInputValidation;

public class CustomerList {
    public HashMap<String, Customer> customerListArray = new HashMap<String, Customer>();
    public Customer currentUser;

    public void loginOrNewUser(){
        System.out.println("\nWould you like to login or create a new user? (enter 1 or 2)\n1 : Login\n2 : Create new user");

        int loginChoice = dataInputValidation(1, 2);
        if (loginChoice == -1){loginOrNewUser();} // redirect after error

        switch (loginChoice){
            case 1:
                login();
                break;
            case 2:
                newCustomer();
                break;
        }
    }

    private void login(){
        String userName = enterUserName();
        currentUser = customerListArray.get(userName);
        if(currentUser == null){
            System.out.println("Username not recognised");
            loginOrNewUser();}
        else{
            System.out.println("Logged in user is: " + currentUser.getName() );  // Confirm logged in & output user input
        }
    }

    private void newCustomer() {
        System.out.println("Welcome to the ETC Lesson booking program");
        String userName = enterUserName();
        currentUser = new Customer(userName); // Create new customer object
        customerListArray.put(userName, currentUser);
        System.out.println("Logged in user is: " + currentUser.getName() );  // Confirm logged in & output user input
    }
    private String enterUserName(){
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter a username:");
        String userInput = myObj.nextLine();  // Read user input
        userInput = userInput.toLowerCase();
        return userInput;
    }

    public void createCustomers(){
        Customer Jamie = new Customer("Jamie");
        Customer John = new Customer("John");
        Customer Emma = new Customer("Emma");
        Customer Olivia = new Customer("Olivia");
        Customer Isabella = new Customer("Isabella");
        Customer Charlotte = new Customer("Charlotte");
        Customer Emily = new Customer("Emily");
        Customer Liam = new Customer("Liam");
        Customer William = new Customer("William");
        Customer James = new Customer("James");
        Customer Oliver = new Customer("Oliver");
        Customer Benjamin = new Customer("Benjamin");
        Customer Jacob = new Customer("Jacob");
        Customer Thomas = new Customer("Thomas");
        Customer Christopher = new Customer("Christopher");
        Customer Victoria = new Customer("Victoria");
        Customer Chloe = new Customer("Chloe");
        Customer Hannah = new Customer("Hannah");
        Customer Luke = new Customer("Luke");
        Customer Rachel = new Customer("Rachel");

        customerListArray.put("jamie", Jamie);
        customerListArray.put("rachel", Rachel);
        customerListArray.put("john", John);
        customerListArray.put("emma", Emma);
        customerListArray.put("olivia", Olivia);
        customerListArray.put("isabella", Isabella);
        customerListArray.put("charlotte", Charlotte);
        customerListArray.put("emily", Emily);
        customerListArray.put("liam", Liam);
        customerListArray.put("william", William);
        customerListArray.put("james", James);
        customerListArray.put("oliver", Oliver);
        customerListArray.put("benjamin", Benjamin);
        customerListArray.put("jacob", Jacob);
        customerListArray.put("thomas", Thomas);
        customerListArray.put("christopher", Christopher);
        customerListArray.put("victoria", Victoria);
        customerListArray.put("chloe", Chloe);
        customerListArray.put("hannah", Hannah);
        customerListArray.put("luke", Luke);
    }


}

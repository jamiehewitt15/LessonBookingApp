package com.company;


public class Main {

    public static void main(String[] args) {

        CustomerList mainCustomerList = new CustomerList();  // initialise CustomerList object
        Menu mainMenu = new Menu();  // initialise Menu object
        Schedule mainSchedule = new Schedule();  // initialise Schedule object

        mainCustomerList.createCustomers(); // generate the test data

        mainCustomerList.loginOrNewUser(); // user logs in or creates a new user

        mainSchedule.initiateSchedule(); // create the lesson schedule for bookings

        mainMenu.showMenu(mainSchedule, mainCustomerList); // Menu is displayed, user chooses options then get redirected to the mainMenu

    }



}


package com.student.coursework;

// Programming and Program Design
// Student Number: 18023219

public class Main {

    public static void main(String[] args) {

        CustomerList mainCustomerList = new CustomerList();  // initialise CustomerList object
        Menu mainMenu = new Menu();  // initialise Menu object
        Schedule mainSchedule = new Schedule();  // initialise Schedule object

        mainCustomerList.createCustomers(); // generate the test data

        mainCustomerList.loginOrNewUser(); // user logs in or creates a new user

        mainSchedule.initiateSchedule(); // create the lesson schedule for bookings
        mainSchedule.createTestData(mainCustomerList); // create bookings with test data
        mainSchedule.createTestDataRatings(mainSchedule); // create ratings with test data
        mainMenu.showMenu(mainSchedule, mainCustomerList); // Menu is displayed, user chooses options then get redirected to the mainMenu

    }



}


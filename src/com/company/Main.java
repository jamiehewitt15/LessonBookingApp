package com.company;

import static com.company.CustomerList.createCustomers;
import static com.company.CustomerList.loginOrNewUser;
import static com.company.Menu.menu; // import the menu() method from the Menu class
import static com.company.Schedule.initiateSchedule; // import the initiateSchedule() method from the Schedule class

public class Main {

    public static void main(String[] args) {
        createCustomers();
        initiateSchedule(); // create the schedule
        loginOrNewUser(); // user logs in or creates a new user
        menu(); // Menu is displayed, user chooses options

    }



}


package com.company;

import static com.company.Customer.login; // import the login() method from the Customer class
import static com.company.Menu.menu; // import the menu() method from the Menu class
import static com.company.Schedule.initiateSchedule; // import the initiateSchedule() method from the Schedule class

public class Main {

    public static void main(String[] args) {

        initiateSchedule(); // create the schedule
        login(); // user logs in and customer object is created
        menu(); // Menu is displayed, user chooses options

    }
}


package com.company;


public class Main {

    public static void main(String[] args) {
        CustomerList mainCustomerList = new CustomerList();
        mainCustomerList.createCustomers();

        mainCustomerList.loginOrNewUser(); // user logs in or creates a new user

        Schedule mainSchedule = new Schedule();
        mainSchedule.initiateSchedule();

        Menu mainMenu = new Menu();
        mainMenu.showMenu(mainSchedule, mainCustomerList); // Menu is displayed, user chooses options

    }



}


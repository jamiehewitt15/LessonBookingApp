package com.company;


import static com.company.Customer.login;
import static com.company.Menu.menu;
import static com.company.Schedule.book;


public class Main {

    public static void main(String[] args) {
	// Introduction code

        String name = login();
        menu();
        String[] classChoice = book();


    }
}


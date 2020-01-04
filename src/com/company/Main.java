package com.company;


import static com.company.Customer.login;
import static com.company.Menu.menu;
import static com.company.Schedule.initiateSchedule;
import java.util.ArrayList; // import the ArrayList class



public class Main {

    public static void main(String[] args) {
	// Introduction code
        initiateSchedule();
        ArrayList<String> Users = new ArrayList<String>();
        String name = login();
        Users.add(name);
        System.out.println(Users);
        menu();




    }
}


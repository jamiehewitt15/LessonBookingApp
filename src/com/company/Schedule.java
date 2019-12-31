package com.company;

import java.util.Scanner;



public class Schedule {
    private static int MaxPerDay = 4; // Maximum number of classes per day
    String[][] className = {
            {"English", "Saturday", "9:00", "£20"},
            {"Math", "Saturday", "15:00", "£10"},
            {"Verbal Reasoning", "Saturday", "19:00", "£12"},
            {"Non-verbal Reasoning", "Saturday", "20:00", "£20"},

            {"Science", "Sunday", "10:00", "£15"},
            {"Math", "Sunday", "15:00", "£10"},
            {"Verbal Reasoning", "Sunday", "19:00", "£12"},
            {"Programming", "Sunday", "20:00", "£25"},
    };

//    String fitnessClassName;
//    boolean fitnessClassSaturday;
//    int fitnessClassTime;

//    public fitnessClass(String name, boolean Saturday, int time){
//        fitnessClassName = name;
//        fitnessClassSaturday = Saturday;
//        fitnessClassTime = time;
//    }


    static String[] book() {

        Schedule menuClasses = new Schedule();
        Scanner classDay = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\nWhat day would you like to book your class on?\n1 : Saturday\n2 : Sunday");
        int classDayChoice = classDay.nextInt();  // Read user input

        switch(classDayChoice) {
            case 1:
                System.out.println("Saturday schedule:"); // code block
                for (int i = 0; i < menuClasses.className.length; i++) {
                    if (menuClasses.className[i][1].equals("Saturday")) {
                        System.out.println(i + 1 + " : " + menuClasses.className[i][0] + " at " + menuClasses.className[i][2] + " | Cost: " + menuClasses.className[i][3]);
                    }
                }
                break;
            case 2:
                for (int i = 0; i < menuClasses.className.length; i++) {
                    if (menuClasses.className[i][1].equals("Sunday")) {
                        System.out.println(i + 1 + " : " + menuClasses.className[i][0] + " at " + menuClasses.className[i][2] + " | Cost: " + menuClasses.className[i][3]);
                    }
                }
                break;
        }

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\nEnter the number to book the class:");

        int classChoice = myObj.nextInt() -1;  // Read user input

        try {
            System.out.println("You have booked class: " + menuClasses.className[classChoice][0] + " on " + menuClasses.className[classChoice][1] + " at " + menuClasses.className[classChoice][2]
                    +  "\nThe price will be:" + menuClasses.className[classChoice][3]);  // Output user input
        } catch (Exception e){
            System.out.println("Sorry, that command wasn't recognised.\nPlease enter one of the numbers that corresponds to a class.");
            book();
        }



        return menuClasses.className[classChoice];
    }

}

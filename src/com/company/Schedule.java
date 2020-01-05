package com.company;

import java.util.ArrayList;
import java.util.Scanner;



public class Schedule {
    public static final int MaxClassesPerDay = 4; // Maximum number of classes per day
    private static final int classCapacity = 5; // Maximum number of people in a class
    public static String[] openDays = {   "Saturday, 1st February", "Sunday, 2nd February",
                            "Saturday, 8th February",  "Sunday, 9th February",
                            "Saturday, 15th February", "Sunday, 16th February",
                            "Saturday, 22nd February","Sunday, 23nd February"
                        };

    public static Class[]  schedule = new Class[12];


    public static void initiateSchedule() {

        Class english = new Class("English", "9:00", 20, new boolean[]{true, false, true, false, false, false, false, false});
        Class maths = new Class("Maths", "15:00", 10, new boolean[]{true, true, true, true, false, false, false, false});
        Class verbalReasoning = new Class("Verbal Reasoning", "19:00", 12, new boolean[]{true, true, true, true, false, false, false, false});
        Class nonVerbalReasoning = new Class("Non-verbal Reasoning", "20:00", 16, new boolean[]{true, true, true, true, false, false, false, false});
        Class biology = new Class("Biology", "10:00", 15, new boolean[]{false, true, false, true, false, false, false, false });
        Class programming = new Class("Programming", "20:00", 25, new boolean[]{false, true, false, true, false, false, false, false});
        Class french = new Class("French", "9:00", 20, new boolean[]{ false, false, false, false, true, false, true, false});
        Class german = new Class("German", "15:00", 10, new boolean[]{false, false, false, false, true, true, true, true});
        Class history = new Class("History", "19:00", 12, new boolean[]{false, false, false, false, true, true, true, true});
        Class economics = new Class("Economics", "20:00", 16, new boolean[]{false, false, false, false, true, false, true, false});
        Class geography = new Class("Geography", "10:00", 15, new boolean[]{false, false, false, false, false, true, false, true});
        Class physics = new Class("Physics", "20:00", 25, new boolean[]{false, false, false, false, false, true, false, true});

        schedule[0] = english;
        schedule[1] = maths;
        schedule[2] = verbalReasoning;
        schedule[3] = nonVerbalReasoning;
        schedule[4] = biology;
        schedule[5] = programming;
        schedule[6] = french;
        schedule[7] = german;
        schedule[8] = history;
        schedule[9] = economics;
        schedule[10] = geography;
        schedule[11] = physics;


    }



    static void book() {


        Scanner classDay = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\nWhat day would you like to book your class on?\n");
        int dayCount = 1;
        for (String i : openDays) {
            System.out.println(dayCount +": "+i); // Show options for days when classes can be booked.
            dayCount++;
        }

        DataValidator dayInputTest = new DataValidator(1, openDays.length);  // Create a DataValidator object
        if(classDay.hasNextInt()) {} else {dayInputTest.errorMessage();} // Test if input is an integer
        int dayChoice = (classDay.nextInt() - 1); // Saving input as an integer
        dayInputTest.testBoundary(dayChoice + 1); // Test if input is within the boundary

        int count = 1;

        System.out.println("\nSchedule:"); // code block
        for (int i = 0; i < schedule.length; i++) {
            if ((schedule[i].getClassDay(dayChoice) == true) && (count <= MaxClassesPerDay) && (schedule[i].getClassAttendance(dayChoice) < classCapacity) ) {
                  System.out.println("\n"+ i + " : " + schedule[i].getClassName() + " at " + schedule[i].getClassTime() + " | Cost: £" + schedule[i].getClassPrice());
                  count++;
                }

        }




        System.out.println("\nEnter the number to book the class:");

        Scanner classScanner = new Scanner(System.in);  // Create a Scanner object
        DataValidator classInputTest = new DataValidator(0, schedule.length);  // Create a DataValidator object
        if(classScanner.hasNextInt()) {} else {classInputTest.errorMessage();} // Test if input is an integer
        int classChoice = classScanner.nextInt();  // Read user input & Saving input as an integer
        classInputTest.testBoundary(classChoice); // Test if input is within the boundary



        schedule[classChoice].increaseClassAttendance(dayChoice); // Update attendance for this class on the chosen day
        schedule[classChoice].setTotalAttendance(); // Update overall attendance count for this class
        schedule[classChoice].setEarnings(); // Update overall earnings generated from this class


        System.out.println("\n-------------------------------------------------" +
                    "\nYou have booked class: " + schedule[classChoice].getClassName() + " at " + schedule[classChoice].getClassTime()
                    + "\nDate: " + openDays[dayChoice]
                    +  "\nThe price will be: £" + schedule[classChoice].getClassPrice()
                    + "\n-------------------------------------------------");  // Output user input


    }

}

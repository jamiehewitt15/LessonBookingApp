package com.company;

import java.util.Scanner;



public class Schedule {
    private final int MaxClassesPerDay = 4; // Maximum number of classes per day
    private final int classCapacity = 20; // Maximum number of people in a class
    String[] openDays = {   "Saturday, 1st February", "Sunday, 2nd February",
                            "Saturday, 8th February",  "Sunday, 9th February",
                            "Saturday, 15th February", "Sunday, 16th February",
                            "Saturday, 22nd February","Sunday, 23nd February"
                        };


    private Class[] schedule = new Class[12];


    public Schedule() {

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

        Schedule menuClasses = new Schedule();
        Scanner classDay = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\nWhat day would you like to book your class on?\n");
        int dayCount = 1;
        for (String i : menuClasses.openDays) {
            System.out.println(dayCount +": "+i); // Show options for days when classes can be booked.
            dayCount++;
        }
        int dayChoice = (classDay.nextInt() - 1);
//
//        System.out.println("\nWhat day would you like to book your class on?\n1 : Saturday\n2 : Sunday");
//        Scanner classDay = new Scanner(System.in);  // Create a Scanner object
//        int classDayChoice = (classDay.nextInt() - 1);  // Read user input
//
        int count = 1;


        System.out.println("\nSchedule:"); // code block
        for (int i = 0; i < menuClasses.schedule.length; i++) {
            if ((menuClasses.schedule[i].getClassDay(dayChoice) == true) && (count <= menuClasses.MaxClassesPerDay)) {
                  System.out.println("\n"+ i + " : " + menuClasses.schedule[i].getClassName() + " at " + menuClasses.schedule[i].getClassTime() + " | Cost: £" + menuClasses.schedule[i].getClassPrice());
                  count++;
                }

        }


        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\nEnter the number to book the class:");

        int classChoice = myObj.nextInt();  // Read user input

        try {
            System.out.println("\n-------------------------------------------------" +
                    "\nYou have booked class: " + menuClasses.schedule[classChoice].getClassName() + " at " + menuClasses.schedule[classChoice].getClassTime()
                    + "\nDate: " + menuClasses.openDays[dayChoice]
                    +  "\nThe price will be: £" + menuClasses.schedule[classChoice].getClassPrice()
                    + "\n-------------------------------------------------");  // Output user input
        } catch (Exception e){
            System.out.println("Sorry, that command wasn't recognised.\nPlease enter one of the numbers that corresponds to a class.");
            book();
        }




    }

}

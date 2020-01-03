package com.company;

import java.util.Scanner;



public class Schedule {
    private final int MaxPerDay = 4; // Maximum number of classes per day
    private Class[] schedule = new Class[6];
//    private Class[] sundayClasses = new Class[MaxPerDay];

//    String[][] className = {
//            {"English", "Saturday", "9:00", "£20", },
//            {"Math", "Saturday", "15:00", "£10"},
//            {"Verbal Reasoning", "Saturday", "19:00", "£12"},
//            {"Non-verbal Reasoning", "Saturday", "20:00", "£20"},
//
//            {"Science", "Sunday", "10:00", "£15"},
//            {"Math", "Sunday", "15:00", "£10"},
//            {"Verbal Reasoning", "Sunday", "19:00", "£12"},
//            {"Programming", "Sunday", "20:00", "£25"},
//    };

    public Schedule() {

        Class english = new Class("English", "9:00", 20, new boolean[]{true, true, true, true}, new boolean[]{true, false}, true, false);
        Class math = new Class("Maths", "15:00", 10, new boolean[]{true, true, true, true}, new boolean[]{true, true}, true, true);
        Class verbalReasoning = new Class("Verbal Reasoning", "19:00", 12, new boolean[]{true, true, true, true}, new boolean[]{true, true}, true, true);
        Class nonVerbalReasoning = new Class("Non-verbal Reasoning", "20:00", 16, new boolean[]{true, true, true, true}, new boolean[]{true, false}, true, false);
        Class science = new Class("Science", "10:00", 15, new boolean[]{true, true, true, true}, new boolean[]{false, true}, false, true);
        Class programming = new Class("Programming", "20:00", 25, new boolean[]{true, true, true, true}, new boolean[]{false, true}, false, true);

        schedule[0] = english;
        schedule[1] = math;
        schedule[2] = verbalReasoning;
        schedule[3] = nonVerbalReasoning;
        schedule[4] = science;
        schedule[5] = programming;
    }



    static void book() {

        Schedule menuClasses = new Schedule();
        Scanner classWeekend = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\nWhich weekend would you like to book your class on?" +
                "\n1 : 1st & 2nd February\n2 : 8th & 9th February\n3 : 15th & 16th February\n4 : 22nd & 23rd February");
        int weekendChoice = (classWeekend.nextInt() - 1);

        System.out.println("\nWhat day would you like to book your class on?\n1 : Saturday\n2 : Sunday");
        Scanner classDay = new Scanner(System.in);  // Create a Scanner object
        int classDayChoice = (classDay.nextInt() - 1);  // Read user input
        int count = 1;

        System.out.println("\nSchedule:"); // code block
        for (int i = 0; i < menuClasses.schedule.length; i++) {
            if (menuClasses.schedule[i].getClassDay(classDayChoice) && menuClasses.schedule[i].getClassWeekend(weekendChoice)) {
                System.out.println("\n"+ count + " : " + menuClasses.schedule[i].getClassName() + " at " + menuClasses.schedule[i].getClassTime() + " | Cost: £" + menuClasses.schedule[i].getClassPrice());
                count++;
            }
        }


//        switch(classDayChoice) {
//
//            case 1:
//                System.out.println("Sunday schedule:"); // code block
//                for (int i = 0; i < menuClasses.schedule.length; i++) {
//                    if (menuClasses.schedule[i].getSaturday() && menuClasses.schedule[i].getClassWeekend(weekendChoice)) {
//                    System.out.println("\n"+ count + " : " + menuClasses.schedule[i].getClassName() + " at " + menuClasses.schedule[i].getClassTime() + " | Cost: £" + menuClasses.schedule[i].getClassPrice());
//                    count++;
//                    }
//                }
//                break;
//            case 2:
//                System.out.println("Saturday schedule:"); // code block
//                for (int i = 0; i < menuClasses.schedule.length; i++) {
//                    if (menuClasses.schedule[i].getSunday()&& menuClasses.schedule[i].getClassWeekend(weekendChoice)) {
//                        System.out.println("\n"+ count + " : " + menuClasses.schedule[i].getClassName() + " at " + menuClasses.schedule[i].getClassTime() + " | Cost: £" + menuClasses.schedule[i].getClassPrice());
//                        count++;
//                    }
//                }
//                break;
//        }

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("\nEnter the number to book the class:");

        int classChoice = myObj.nextInt() -1;  // Read user input

        try {
            System.out.println("\n-------------------------------------------------" +
                    "\nYou have booked class: " + menuClasses.schedule[classChoice].getClassName() + " at " + menuClasses.schedule[classChoice].getClassTime()
                    +  "\nThe price will be: £" + menuClasses.schedule[classChoice].getClassPrice()
                    + "\n-------------------------------------------------");  // Output user input
        } catch (Exception e){
            System.out.println("Sorry, that command wasn't recognised.\nPlease enter one of the numbers that corresponds to a class.");
            book();
        }




    }

}

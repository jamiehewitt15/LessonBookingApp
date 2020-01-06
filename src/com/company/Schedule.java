package com.company;

import java.util.Scanner;



public class Schedule {
    public static final int MaxClassesPerDay = 4; // Maximum number of classes per day
    private static final int MaxClassesMorning = 1; // Maximum number of classes per day
    private static final int MaxClassesAfternoon = 1; // Maximum number of classes per day
    private static final int MaxClassesEvening = 2; // Maximum number of classes per day
    public static final int classCapacity = 5; // Maximum number of people in a class

    // openDays are the dates that will be used in the schedule
    // To repeat the 4 week period, openDays can be changed to reflect the new dates
    private static String[] openDays = {   "Saturday, 1st February", "Sunday, 2nd February",
                            "Saturday, 8th February",  "Sunday, 9th February",
                            "Saturday, 15th February", "Sunday, 16th February",
                            "Saturday, 22nd February","Sunday, 23nd February"
                        };

    // creating the array that will hold the schedule. If new classes are added the size of this array needs to be changed
    public static TuitionClass[]  schedule = new TuitionClass[12];

    public static String[] getOpenDays() { return openDays;} // Method to return openDays array
    public static String getOpenDays(int i) { return openDays[i];} // Method to return individual openDays strings

    public static void initiateSchedule() { // this method is called at the start of Main to create the schedule.

        // Creating the class objects
        TuitionClass english = new TuitionClass("English", 9, 20, new boolean[]{true, false, true, false, false, false, false, false});
        TuitionClass maths = new TuitionClass("Maths", 15, 10, new boolean[]{true, true, true, true, false, false, false, false});
        TuitionClass verbalReasoning = new TuitionClass("Verbal Reasoning", 19, 12, new boolean[]{true, true, true, true, false, false, false, false});
        TuitionClass nonVerbalReasoning = new TuitionClass("Non-verbal Reasoning", 20, 16, new boolean[]{true, true, true, true, false, false, false, false});
        TuitionClass biology = new TuitionClass("Biology", 9, 15, new boolean[]{false, true, false, true, false, false, false, false });
        TuitionClass programming = new TuitionClass("Programming", 20, 25, new boolean[]{false, true, false, true, false, false, false, false});
        TuitionClass french = new TuitionClass("French", 9, 20, new boolean[]{ false, false, false, false, true, false, true, false});
        TuitionClass german = new TuitionClass("German", 15, 10, new boolean[]{false, false, false, false, true, true, true, true});
        TuitionClass history = new TuitionClass("History", 19, 12, new boolean[]{false, false, false, false, true, true, true, true});
        TuitionClass economics = new TuitionClass("Economics", 20, 16, new boolean[]{false, false, false, false, true, false, true, false});
        TuitionClass geography = new TuitionClass("Geography", 9, 15, new boolean[]{false, false, false, false, false, true, false, true});
        TuitionClass physics = new TuitionClass("Physics", 20, 25, new boolean[]{false, false, false, false, false, true, false, true});

        // Adding the class objects to the schedule array
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

        // Sub-menu for choosing the day for the class
        System.out.println("\nWhat day would you like to book your class on?\n");
        int dayCount = 1;
        for (String i : openDays) { // Looping through openDays array to show the customer days when the classes are available
            System.out.println(dayCount +": "+i); // Print options for days when classes can be booked.
            dayCount++;
        }

        // Test for valid user input
        Scanner classDay = new Scanner(System.in);  // Create a Scanner object
        DataValidator dayInputTest = new DataValidator(1, openDays.length);  // Create a DataValidator object
        if(classDay.hasNextInt()) {} else {dayInputTest.errorMessage();} // Test if input is an integer
        int dayChoice = (classDay.nextInt() - 1); // Saving input as an integer
        dayInputTest.testBoundary(dayChoice + 1); // Test if input is within the boundary

        //initialising variables to count how many classes are in the schedule per day and at each time slot
        int classCount = 0;
        int morningCount = 0;
        int afternoonCount = 0;
        int eveningCount = 0;

        System.out.println("\nSchedule:");

        // Create morning schedule for the chosen day
        for (int i = 0; i < schedule.length; i++) {

            // if statement checks the class is on that day, number of classes on day is less than maximum,
            // attendance is less than the class capacity, class time is in the morning, morning classes are less than allowed
            if ((schedule[i].getClassDay(dayChoice) == true) && (classCount <= MaxClassesPerDay) && (schedule[i].getClassAttendance(dayChoice) < classCapacity) && schedule[i].getClassTime() == 9 && morningCount < MaxClassesMorning) {
                    System.out.println("\nMorning Class\n\t"+ i + " : " + schedule[i].getClassName() + " at " + schedule[i].getClassTime() + ":00 | Cost: £" + schedule[i].getClassPrice());
                    morningCount++; // increase the count of classes at this time slot
                    classCount++; // increase the count of classes on this day
            }
        }

        // Create Afternoon schedule for the chosen day
        for (int i = 0; i < schedule.length; i++) {

            // if statement checks the class is on that day, number of classes on day is less than maximum,
            // attendance is less than the class capacity, class time is in the afternoon, afternoon classes are less than allowed
            if ((schedule[i].getClassDay(dayChoice) == true) && (classCount <= MaxClassesPerDay) && (schedule[i].getClassAttendance(dayChoice) < classCapacity) && schedule[i].getClassTime() == 15 && afternoonCount < MaxClassesAfternoon) {
                System.out.println("\nAfternoon Class\n\t"+ i + " : " + schedule[i].getClassName() + " at " + schedule[i].getClassTime() + ":00 | Cost: £" + schedule[i].getClassPrice());
                afternoonCount++; // increase the count of classes at this time slot
                classCount++; // increase the count of classes on this day
            }
        }

        // Create first evening class for the chosen day at 7pm
        for (int i = 0; i < schedule.length; i++) {

            // if statement checks the class is on that day, number of classes on day is less than maximum,
            // attendance is less than the class capacity, class time is 7pm, evening classes are less than allowed
            if ((schedule[i].getClassDay(dayChoice) == true) && (classCount <= MaxClassesPerDay) && (schedule[i].getClassAttendance(dayChoice) < classCapacity) && schedule[i].getClassTime() == 19 && eveningCount < MaxClassesEvening) {
                System.out.println("\nEvening Classes\n\t"+ i + " : " + schedule[i].getClassName() + " at " + schedule[i].getClassTime() + ":00 | Cost: £" + schedule[i].getClassPrice());
                eveningCount++; // increase the count of classes at this time slot
                classCount++; // increase the count of classes on this day
            }
        }

        // Create second evening class for the chosen day at 8pm
        for (int i = 0; i < schedule.length; i++) {

            // if statement checks the class is on that day, number of classes on day is less than maximum,
            // attendance is less than the class capacity, class time is 8pm, morning classes are less than allowed
            if ((schedule[i].getClassDay(dayChoice) == true) && (classCount <= MaxClassesPerDay) && (schedule[i].getClassAttendance(dayChoice) < classCapacity) && schedule[i].getClassTime() == 20 && eveningCount < MaxClassesEvening) {
                System.out.println("\t"+ i + " : " + schedule[i].getClassName() + " at " + schedule[i].getClassTime() + ":00 | Cost: £" + schedule[i].getClassPrice());
                eveningCount++; // increase the count of classes at this time slot
                classCount++; // increase the count of classes on this day
            }
        }

        // receive user choice
        System.out.println("\nEnter the number to book the class:");

        // Test for valid user input
        Scanner classScanner = new Scanner(System.in);  // Create a Scanner object
        DataValidator classInputTest = new DataValidator(0, schedule.length);  // Create a DataValidator object
        if(classScanner.hasNextInt()) {} else {classInputTest.errorMessage();} // Test if input is an integer
        int classChoice = classScanner.nextInt();  // Read user input & Saving input as an integer
        classInputTest.testBoundary(classChoice); // Test if input is within the boundary




        schedule[classChoice].increaseClassAttendance(dayChoice); // Update attendance for this class on the chosen day
        schedule[classChoice].setTotalAttendance(); // Update overall attendance count for this class
        schedule[classChoice].setEarnings(); // Update overall earnings generated from this class
        schedule[classChoice].setClassStudents(dayChoice); // Add current customer name to list of students enrolled in this class on this day

        // Print out confirmation of the booking.
        System.out.println("\n-------------------------------------------------" +
                    "\nYou have booked class: " + schedule[classChoice].getClassName() + " at " + schedule[classChoice].getClassTime()+":00"
                    + "\nDate: " + openDays[dayChoice]
                    +  "\nThe price will be: £" + schedule[classChoice].getClassPrice()
                    + "\n-------------------------------------------------");  // Output user input


    }

}

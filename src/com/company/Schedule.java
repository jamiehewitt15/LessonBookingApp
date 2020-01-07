package com.company;

import java.util.Scanner;



public class Schedule {
    public static final int maxLessonsPerDay = 4; // Maximum number of classes per day
    private static final int maxClassesMorning = 1; // Maximum number of classes per day
    private static final int maxClassesAfternoon = 1; // Maximum number of classes per day
    private static final int maxClassesEvening = 2; // Maximum number of classes per day
    public static final int lessonCapacity = 5; // Maximum number of people in a class

    // openDays are the dates that will be used in the schedule
    // To repeat the 4 week period, openDays can be changed to reflect the new dates
    private static String[] openDays = {   "Saturday, 1st February", "Sunday, 2nd February",
                            "Saturday, 8th February",  "Sunday, 9th February",
                            "Saturday, 15th February", "Sunday, 16th February",
                            "Saturday, 22nd February","Sunday, 23nd February"
                        };

    // creating the array that will hold the schedule. If new classes are added the size of this array needs to be changed
    public static Lesson[]  schedule = new Lesson[12];

    public static String[] getOpenDays() { return openDays;} // Method to return openDays array
    public static String getOpenDays(int i) { return openDays[i];} // Method to return individual openDays strings

    public static void initiateSchedule() { // this method is called at the start of Main to create the schedule.

        // Creating the class objects
        Lesson english = new Lesson("English", 9, 20, new boolean[]{true, false, true, false, false, false, false, false});
        Lesson maths = new Lesson("Maths", 15, 10, new boolean[]{true, true, true, true, false, false, false, false});
        Lesson verbalReasoning = new Lesson("Verbal Reasoning", 19, 12, new boolean[]{true, true, true, true, false, false, false, false});
        Lesson nonVerbalReasoning = new Lesson("Non-verbal Reasoning", 20, 16, new boolean[]{true, true, true, true, false, false, false, false});
        Lesson biology = new Lesson("Biology", 9, 15, new boolean[]{false, true, false, true, false, false, false, false });
        Lesson programming = new Lesson("Programming", 20, 25, new boolean[]{false, true, false, true, false, false, false, false});
        Lesson french = new Lesson("French", 9, 20, new boolean[]{ false, false, false, false, true, false, true, false});
        Lesson german = new Lesson("German", 15, 10, new boolean[]{false, false, false, false, true, true, true, true});
        Lesson history = new Lesson("History", 19, 12, new boolean[]{false, false, false, false, true, true, true, true});
        Lesson economics = new Lesson("Economics", 20, 16, new boolean[]{false, false, false, false, true, false, true, false});
        Lesson geography = new Lesson("Geography", 9, 15, new boolean[]{false, false, false, false, false, true, false, true});
        Lesson physics = new Lesson("Physics", 20, 25, new boolean[]{false, false, false, false, false, true, false, true});

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



    static void bookLesson() {

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
            if ((schedule[i].getClassDay(dayChoice) == true) && (classCount <= maxLessonsPerDay) && (schedule[i].getClassAttendance(dayChoice) < lessonCapacity) && schedule[i].getLessonTime() == 9 && morningCount < maxClassesMorning) {
                    System.out.println("\nMorning Class\n\t"+ i + " : " + schedule[i].getLessonName() + " at " + schedule[i].getLessonTime() + ":00 | Cost: £" + schedule[i].getClassPrice());
                    morningCount++; // increase the count of classes at this time slot
                    classCount++; // increase the count of classes on this day
            }
        }

        // Create Afternoon schedule for the chosen day
        for (int i = 0; i < schedule.length; i++) {

            // if statement checks the class is on that day, number of classes on day is less than maximum,
            // attendance is less than the class capacity, class time is in the afternoon, afternoon classes are less than allowed
            if ((schedule[i].getClassDay(dayChoice) == true) && (classCount <= maxLessonsPerDay) && (schedule[i].getClassAttendance(dayChoice) < lessonCapacity) && schedule[i].getLessonTime() == 15 && afternoonCount < maxClassesAfternoon) {
                System.out.println("\nAfternoon Class\n\t"+ i + " : " + schedule[i].getLessonName() + " at " + schedule[i].getLessonTime() + ":00 | Cost: £" + schedule[i].getClassPrice());
                afternoonCount++; // increase the count of classes at this time slot
                classCount++; // increase the count of classes on this day
            }
        }

        // Create first evening class for the chosen day at 7pm
        for (int i = 0; i < schedule.length; i++) {

            // if statement checks the class is on that day, number of classes on day is less than maximum,
            // attendance is less than the class capacity, class time is 7pm, evening classes are less than allowed
            if ((schedule[i].getClassDay(dayChoice) == true) && (classCount <= maxLessonsPerDay) && (schedule[i].getClassAttendance(dayChoice) < lessonCapacity) && schedule[i].getLessonTime() == 19 && eveningCount < maxClassesEvening) {
                System.out.println("\nEvening Classes\n\t"+ i + " : " + schedule[i].getLessonName() + " at " + schedule[i].getLessonTime() + ":00 | Cost: £" + schedule[i].getClassPrice());
                eveningCount++; // increase the count of classes at this time slot
                classCount++; // increase the count of classes on this day
            }
        }

        // Create second evening class for the chosen day at 8pm
        for (int i = 0; i < schedule.length; i++) {

            // if statement checks the class is on that day, number of classes on day is less than maximum,
            // attendance is less than the class capacity, class time is 8pm, morning classes are less than allowed
            if ((schedule[i].getClassDay(dayChoice) == true) && (classCount <= maxLessonsPerDay) && (schedule[i].getClassAttendance(dayChoice) < lessonCapacity) && schedule[i].getLessonTime() == 20 && eveningCount < maxClassesEvening) {
                System.out.println("\t"+ i + " : " + schedule[i].getLessonName() + " at " + schedule[i].getLessonTime() + ":00 | Cost: £" + schedule[i].getClassPrice());
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
                    "\nYou have booked class: " + schedule[classChoice].getLessonName() + " at " + schedule[classChoice].getLessonTime()+":00"
                    + "\nDate: " + openDays[dayChoice]
                    +  "\nThe price will be: £" + schedule[classChoice].getClassPrice()
                    + "\n-------------------------------------------------");  // Output user input

        // Payment request
        System.out.println("\nHow would you like to pay?\n1 : Card\n2 : Cash");

        Scanner paymentScanner = new Scanner(System.in);  // Create a Scanner object
        // Test for valid user input
        DataValidator paymentInputTest = new DataValidator(1, 2);  // Create a DataValidator object
        if(paymentScanner.hasNextInt()) {} else {paymentInputTest.errorMessage();} // Test if input is an integer
        int paymentChoice = paymentScanner.nextInt();  // Read user input & Saving input as an integer
        paymentInputTest.testBoundary(paymentChoice); // Test if input is within the boundary

        switch (paymentChoice){
            case 1:
                System.out.println("\nPlease bring your card with you to the class to pay £" + schedule[classChoice].getClassPrice());
                break;
            case 2:
                System.out.println("\nPlease bring £" + schedule[classChoice].getClassPrice() + " cash with you to the class");
                break;
        }

    }

}

package com.company;

import static com.company.DataValidator.dataInputValidation;

public class Schedule {
    public final int maxLessonsPerDay = 4; // Maximum number of Lesson per day
    private final int maxLessonMorning = 1; // Maximum number of Lesson per day
    private final int maxLessonAfternoon = 1; // Maximum number of Lesson per day
    private final int maxLessonEvening = 2; // Maximum number of Lesson per day
    public final int lessonCapacity = 5; // Maximum number of people in a Lesson


    // openDays are the dates that will be used in the schedule
    // To repeat the 4 week period, openDays can be changed to reflect the new dates
    private  String[] openDays = {   "Saturday, 1st February", "Sunday, 2nd February",
                            "Saturday, 8th February",  "Sunday, 9th February",
                            "Saturday, 15th February", "Sunday, 16th February",
                            "Saturday, 22nd February","Sunday, 23nd February"
                        };


    public Lesson[] scheduleArray = new Lesson[12]; // creating the array that will hold the schedule. If new Lessons are added the size of this array needs to be changed
    public String[] getOpenDays() { return openDays;} // Method to return openDays array
    public String getOpenDays(int i) { return openDays[i];} // Method to return individual openDays strings
    public void initiateSchedule() { // this method is called at the start of Main to create the schedule.

        // Creating the Lesson objects
        Lesson english = new Lesson("English", 9, 20, new boolean[]{true, false, true, false, false, false, false, false}, lessonCapacity);
        Lesson maths = new Lesson("Maths", 15, 10, new boolean[]{true, true, true, true, false, false, false, false}, lessonCapacity);
        Lesson verbalReasoning = new Lesson("Verbal Reasoning", 19, 12, new boolean[]{true, true, true, true, false, false, false, false}, lessonCapacity);
        Lesson nonVerbalReasoning = new Lesson("Non-verbal Reasoning", 20, 16, new boolean[]{true, false, true, false, false, false, false, false}, lessonCapacity);
        Lesson biology = new Lesson("Biology", 9, 15, new boolean[]{false, true, false, true, false, false, false, false }, lessonCapacity);
        Lesson programming = new Lesson("Programming", 20, 25, new boolean[]{false, true, false, true, false, false, false, false}, lessonCapacity);
        Lesson french = new Lesson("French", 9, 20, new boolean[]{ false, false, false, false, true, false, true, false}, lessonCapacity);
        Lesson german = new Lesson("German", 15, 10, new boolean[]{false, false, false, false, true, true, true, true}, lessonCapacity);
        Lesson history = new Lesson("History", 19, 12, new boolean[]{false, false, false, false, true, true, true, true}, lessonCapacity);
        Lesson economics = new Lesson("Economics", 20, 16, new boolean[]{false, false, false, false, true, false, true, false}, lessonCapacity);
        Lesson geography = new Lesson("Geography", 9, 15, new boolean[]{false, false, false, false, false, true, false, true}, lessonCapacity);
        Lesson physics = new Lesson("Physics", 20, 25, new boolean[]{false, false, false, false, false, true, false, true}, lessonCapacity);

        // Adding the Lesson objects to the schedule array
        scheduleArray[0] = english;
        scheduleArray[1] = maths;
        scheduleArray[2] = verbalReasoning;
        scheduleArray[3] = nonVerbalReasoning;
        scheduleArray[4] = biology;
        scheduleArray[5] = programming;
        scheduleArray[6] = french;
        scheduleArray[7] = german;
        scheduleArray[8] = history;
        scheduleArray[9] = economics;
        scheduleArray[10] = geography;
        scheduleArray[11] = physics;


    }

    public void bookLesson(CustomerList customerList) {

        int dayChoice = chooseDay();
        int lessonCount = 0; //initialising variable to count how many lessons are in the schedule per day and at each time slot

        System.out.println("\nSchedule:");
        lessonCount = showSchedule(dayChoice, 9, "\nMorning Lesson\n\t", maxLessonMorning, lessonCount); // Create morning schedule for the chosen day
        lessonCount = showSchedule(dayChoice, 15, "\nAfternoon Lesson\n\t", maxLessonAfternoon, lessonCount); // Create afternoon schedule for the chosen day
        lessonCount = showSchedule(dayChoice, 19, "\nEvening Lesson\n\t", maxLessonEvening, lessonCount); // Create evening schedule for the chosen day
        lessonCount = showSchedule(dayChoice, 20,"\t" , maxLessonEvening, lessonCount); // Create evening schedule for the chosen day

        System.out.println("\nEnter the number to book the lesson:");

        int lessonChoice = dataInputValidation(1, openDays.length);

        scheduleArray[lessonChoice].increaseLessonAttendance(dayChoice); // Update attendance for this Lesson on the chosen day
        scheduleArray[lessonChoice].setTotalAttendance(); // Update overall attendance count for this Lesson
        scheduleArray[lessonChoice].setEarnings(); // Update overall earnings generated from this Lesson
        scheduleArray[lessonChoice].setLessonStudents(dayChoice, customerList); // Add current customer name to list of students enrolled in this Lesson on this day

        bookingConfirmation(lessonChoice, dayChoice); // Print out confirmation of the booking.
        choosePayment(lessonChoice); // Payment request
    }

    private int chooseDay(){
        System.out.println("\nWhat day would you like to book your lesson on?\n");
        int dayCount = 1;
        for (String i : openDays) { // Looping through openDays array to show the customer days when the lessons are available
            System.out.println(dayCount +": "+i); // Print options for days when lessons can be booked.
            dayCount++;
        }
        int dayChoice = dataInputValidation(1, openDays.length);
        return --dayChoice;
    }

    private int showSchedule(int dayChoice, int time, String title, int maxLessons, int dayLessonCount){ // Create schedule for the chosen day at given time "\nMorning Lesson\n\t"
        for (int i = 0; i < scheduleArray.length; i++) {
            int lessonCount = 0;
            // if statement checks the lesson is on that day, number of lessons on day is less than maximum,
            // attendance is less than the lesson capacity, lesson time is in the morning, morning lessons are less than allowed
            if ((scheduleArray[i].getLessonDay(dayChoice) == true) && (dayLessonCount <= maxLessonsPerDay) && (scheduleArray[i].getLessonAttendance(dayChoice) < lessonCapacity) && scheduleArray[i].getLessonTime() == time && lessonCount < maxLessons) {
                System.out.println(title+ i + " : " + scheduleArray[i].getLessonName() + " at " + scheduleArray[i].getLessonTime() + ":00 | Cost: £" + scheduleArray[i].getLessonPrice());
                lessonCount++; // increase the count of lessons at this time slot
                dayLessonCount++;
            }
        }
        return dayLessonCount;
    }
    private void bookingConfirmation(int lessonChoice, int dayChoice){
        System.out.println("\n-------------------------------------------------" +
                "\nYou have booked lesson: " + scheduleArray[lessonChoice].getLessonName() + " at " + scheduleArray[lessonChoice].getLessonTime()+":00"
                + "\nDate: " + openDays[dayChoice]
                +  "\nThe price will be: £" + scheduleArray[lessonChoice].getLessonPrice()
                + "\n-------------------------------------------------");  // Output user input

    }
    private void choosePayment(int lessonChoice){
        System.out.println("\nHow would you like to pay?\n1 : Card\n2 : Cash");
        int paymentChoice = dataInputValidation(1, 2);

        switch (paymentChoice){
            case 1:
                System.out.println("\nPlease bring your card with you to the lesson to pay £" + scheduleArray[lessonChoice].getLessonPrice());
                break;
            case 2:
                System.out.println("\nPlease bring £" + scheduleArray[lessonChoice].getLessonPrice() + " cash with you to the lesson");
                break;
        }
    }
}

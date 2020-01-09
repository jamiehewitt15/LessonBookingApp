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

        int lessonChoice = dataInputValidation(0, scheduleArray.length);
        if (lessonChoice == -1){bookLesson(customerList);} // redirect after error

        bookingEntry(dayChoice, lessonChoice, customerList, customerList.currentUser);

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
        if (dayChoice == -1){dayChoice = chooseDay() + 1;} // redirect after error
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
        if (paymentChoice == -1){choosePayment(lessonChoice);} // redirect after error
        switch (paymentChoice){
            case 1:
                System.out.println("\nPlease bring your card with you to the lesson to pay £" + scheduleArray[lessonChoice].getLessonPrice());
                break;
            case 2:
                System.out.println("\nPlease bring £" + scheduleArray[lessonChoice].getLessonPrice() + " cash with you to the lesson");
                break;
        }
    }

    private void bookingEntry(int dayChoice, int lessonChoice, CustomerList customerList, Customer user){
        scheduleArray[lessonChoice].increaseLessonAttendance(dayChoice); // Update attendance for this Lesson on the chosen day
        scheduleArray[lessonChoice].setTotalAttendance(); // Update overall attendance count for this Lesson
        scheduleArray[lessonChoice].setEarnings(); // Update overall earnings generated from this Lesson
        customerList.currentUser = user;
        scheduleArray[lessonChoice].setLessonStudents(dayChoice, customerList);

    }

    public void createTestData(CustomerList customerList){
        bookingEntry(0, 0, customerList, customerList.customerListArray.get("jamie"));
        bookingEntry(0, 0, customerList, customerList.customerListArray.get("rachel"));
        bookingEntry(0, 1, customerList, customerList.customerListArray.get("john"));
        bookingEntry(1, 2, customerList, customerList.customerListArray.get("emma"));
        bookingEntry(1, 5, customerList, customerList.customerListArray.get("olivia"));
        bookingEntry(2, 1, customerList, customerList.customerListArray.get("isabella"));
        bookingEntry(2, 2, customerList, customerList.customerListArray.get("charlotte"));
        bookingEntry(2, 3, customerList, customerList.customerListArray.get("emily"));
        bookingEntry(3, 4, customerList, customerList.customerListArray.get("liam"));
        bookingEntry(3, 2, customerList, customerList.customerListArray.get("william"));
        bookingEntry(3, 5, customerList, customerList.customerListArray.get("oliver"));
        bookingEntry(4, 6, customerList, customerList.customerListArray.get("benjamin"));
        bookingEntry(4, 7, customerList, customerList.customerListArray.get("jacob"));
        bookingEntry(4, 8, customerList, customerList.customerListArray.get("thomas"));
        bookingEntry(5, 10, customerList, customerList.customerListArray.get("christopher"));
        bookingEntry(5, 7, customerList, customerList.customerListArray.get("victoria"));
        bookingEntry(5, 8, customerList, customerList.customerListArray.get("chloe"));
        bookingEntry(6, 6, customerList, customerList.customerListArray.get("hannah"));
        bookingEntry(6, 7, customerList, customerList.customerListArray.get("benjamin"));
        bookingEntry(6, 8, customerList, customerList.customerListArray.get("jacob"));
        bookingEntry(6, 9, customerList, customerList.customerListArray.get("thomas"));
        bookingEntry(7, 10, customerList, customerList.customerListArray.get("luke"));
        bookingEntry(7, 7, customerList, customerList.customerListArray.get("jamie"));
        bookingEntry(7, 8, customerList, customerList.customerListArray.get("rachel"));
        bookingEntry(7, 11, customerList, customerList.customerListArray.get("john"));
        bookingEntry(7, 10, customerList, customerList.customerListArray.get("emma"));
    }

    public void createTestDataRatings(Schedule schedule){
        schedule.scheduleArray[0].getRating().addRating(2); // Add the rating and update the average.
        schedule.scheduleArray[1].getRating().addRating(2); // Add the rating and update the average.
        schedule.scheduleArray[2].getRating().addRating(3); // Add the rating and update the average.
        schedule.scheduleArray[5].getRating().addRating(4); // Add the rating and update the average.
        schedule.scheduleArray[1].getRating().addRating(5); // Add the rating and update the average.
        schedule.scheduleArray[2].getRating().addRating(5); // Add the rating and update the average.
        schedule.scheduleArray[3].getRating().addRating(5); // Add the rating and update the average.
        schedule.scheduleArray[4].getRating().addRating(4); // Add the rating and update the average.
        schedule.scheduleArray[2].getRating().addRating(5); // Add the rating and update the average.
        schedule.scheduleArray[5].getRating().addRating(4); // Add the rating and update the average.
        schedule.scheduleArray[6].getRating().addRating(3); // Add the rating and update the average.
        schedule.scheduleArray[7].getRating().addRating(4); // Add the rating and update the average.
        schedule.scheduleArray[8].getRating().addRating(3); // Add the rating and update the average.
        schedule.scheduleArray[10].getRating().addRating(2); // Add the rating and update the average.
        schedule.scheduleArray[7].getRating().addRating(4); // Add the rating and update the average.
        schedule.scheduleArray[8].getRating().addRating(3); // Add the rating and update the average.
        schedule.scheduleArray[6].getRating().addRating(5); // Add the rating and update the average.
        schedule.scheduleArray[7].getRating().addRating(5); // Add the rating and update the average.
        schedule.scheduleArray[8].getRating().addRating(5); // Add the rating and update the average.
        schedule.scheduleArray[9].getRating().addRating(5); // Add the rating and update the average.
        schedule.scheduleArray[10].getRating().addRating(4); // Add the rating and update the average.
        schedule.scheduleArray[7].getRating().addRating(3); // Add the rating and update the average.
        schedule.scheduleArray[8].getRating().addRating(4); // Add the rating and update the average.
        schedule.scheduleArray[11].getRating().addRating(3); // Add the rating and update the average.
        schedule.scheduleArray[10].getRating().addRating(1); // Add the rating and update the average.
    }


}

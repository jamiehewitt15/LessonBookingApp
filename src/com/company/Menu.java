package com.company;

import java.util.ArrayList;

import static com.company.DataValidator.dataInputValidation;

public class Menu {

    private String[] menuOptions = {        "Book Lesson", "Rate Lesson",
                                            "Show Report",  "Change user",
                                            "Cancel Lesson booking", "Show my bookings",
                                            "Close programme" };

    public void showMenu(Schedule schedule, CustomerList customerList) {

            System.out.println("\n\nEnter the number to select:\n");
            int optionCount = 1;
            for (String i : menuOptions) { // Looping through menuOptions array to show the menu
                System.out.println(optionCount +" : "+i); // Print menu options.
                optionCount++;
            }

            int menuSelect = dataInputValidation(1, menuOptions.length); // Test for valid user input and save input
            if (menuSelect == -1){showMenu(schedule, customerList);} // redirect after error

            switch(menuSelect) {
                case 1: // book a lesson
                    schedule.bookLesson(customerList);
                    showMenu(schedule, customerList);
                    break;
                case 2: // Enter Review
                    rateLesson(schedule);
                    showMenu(schedule, customerList);
                    break;
                case 3: // Option for reports
                    chooseReport(schedule);
                    showMenu(schedule, customerList);
                    break;
                case 4: // Change user
                    customerList.loginOrNewUser();
                    showMenu(schedule, customerList);
                    break;
                case 5: // Change booking
                    changeLesson(schedule, customerList);
                    showMenu(schedule, customerList);
                    break;
                case 6: // Show booked lessons
                    showBookedLessons(schedule, customerList);
                    showMenu(schedule, customerList);
                    break;
                case 7: // Option to quit
                    quit(schedule, customerList);
                    break;
                default:  // Default option provides redundancy as the data validator should stop other input.
                    System.out.println("Please select again"); // print message
            }
    }
    private void quit(Schedule schedule, CustomerList customerList){
        System.out.println("\n\nAre you sure you would like to quit?\nYou may lose unsaved information\n1 : Show main menu\n2 : Exit");  // Output user input
        int menuSelect = dataInputValidation(1, 2); // Test for valid user input and save input
        if (menuSelect == -1){quit(schedule, customerList);}

        switch(menuSelect) {
            case 1:
                showMenu(schedule, customerList);
                break;
            case 2:
                System.out.println("Thank you, goodbye!");// code block
                break;
            default:
                System.out.println("Sorry that command isn't recognised"); // code block
                showMenu(schedule, customerList);
        }
    }

    private void rateLesson(Schedule schedule){
        System.out.println("\nWhich Lesson would you like to rate?\n");
        int lessonCount = 1;
        for (Lesson lessonObject : schedule.scheduleArray) {
            System.out.println(lessonCount +": "+ lessonObject.getLessonName() ); // Show options for days when lessons can be booked.
            lessonCount++;
        }

        int ratingSelect = dataInputValidation(1, schedule.scheduleArray.length); // Test for valid user input and save input
        if (ratingSelect == -1){rateLesson(schedule);}

        System.out.println("\nPlease type your rating (1-5) for " + schedule.scheduleArray[ratingSelect].getLessonName() + ":\n1: Very dissatisfied\n2: Dissatisfied\n3: Ok\n4: Satisfied\n5: Very Satisfied");// code block

        int ratingInput = dataInputValidation(1, 5); // Test for valid user input and save input
        if (ratingSelect == -1){rateLesson(schedule);}

        schedule.scheduleArray[ratingSelect].getRating().addRating(ratingInput); // Add the rating and update the average.

        System.out.println("\nThank you for your rating.\nYou have rated " + schedule.scheduleArray[ratingSelect].getLessonName() + " " + ratingInput + " out of 5\n");// Show rating in output
        Rating reviewRating = new Rating();
        reviewRating.ratingString(ratingSelect, schedule);
    }

    private void chooseReport(Schedule schedule){
        System.out.println("\nWhat type of report would you like?");
        Report newReport = new Report();

        int reportOptionCount = 1;
        for (String i : newReport.getAvailableReports()) { // Looping through availableReports array to show the menu
            System.out.println(reportOptionCount +" : "+i); // Print report options.
            reportOptionCount++;
        }

        int reportChoice = dataInputValidation(1, reportOptionCount);
        if (reportChoice == -1){chooseReport(schedule);} // redirect after error

        // Switch statement selects the different report options
        switch (reportChoice){
            case 1:
                newReport.earningsReport(schedule);
                break;
            case 2:
                newReport.attendanceReport(schedule);
                break;
            case 3:
                newReport.ratingReport(schedule);
                break;
        }
    }

    private void changeLesson(Schedule schedule, CustomerList customerList){
        System.out.println("\nEnter the number of the lesson you would like to cancel:");
        ArrayList<int[]> deleteOptions = showBookedLessons(schedule, customerList);
        int deleteChoice = dataInputValidation(1, (schedule.scheduleArray.length*8* schedule.maxLessonsPerDay)); // Test for valid user input and save input
        if (deleteChoice == -1){changeLesson(schedule, customerList);} // redirect after error
        int reBookChoice = cancelLesson(deleteOptions, deleteChoice, schedule, customerList);
        switch (reBookChoice){
            case 1:
                schedule.bookLesson(customerList); // book another lesson
                showMenu(schedule, customerList);
                break;
            case 2:
                showMenu(schedule, customerList);
        }
    }

    private ArrayList<int[]> showBookedLessons(Schedule schedule, CustomerList customerList){

        ArrayList<int[]> bookedLessons = new ArrayList<int[]>(); // Create an ArrayList object to store all of the options
        int count = 1; // count how many options there are
        // print all of the lessons that the current student is enrolled in
        for (int i = 0; i < schedule.scheduleArray.length; ++i) {
            for (int j = 0; j < schedule.scheduleArray[i].getLessonStudents().length; ++j) {
                for (int k = 0; k < schedule.lessonCapacity; ++k) {
                    if (schedule.scheduleArray[i].getLessonStudents(j, k) == customerList.currentUser.getName()){
                        System.out.println(count + " : " + schedule.scheduleArray[i].getLessonName() + " on " + schedule.getOpenDays(j) + " at " + schedule.scheduleArray[i].getLessonTime() + ":00");// Print lessons
                        bookedLessons.add(new int[]{count, i, j, k}); // add the available lessons to the deleteOptions array List
                        count++;
                    }
                }
            }
        }
        if(count-1 == 0){System.out.println("No booked classes");
            showMenu(schedule, customerList);}

    return bookedLessons;
    }

    private int cancelLesson(ArrayList<int[]> options, int choice, Schedule schedule, CustomerList customerList){
        for (int i = 0; i < options.size(); ++i) {
            if(choice == options.get(choice-1)[0]){
                // decrease the total attendance count for the selected lesson
                schedule.scheduleArray[options.get(choice-1)[1]].decreaseTotalAttendance();
                // decrease the attendance count for the selected lesson on the specific name
                schedule.scheduleArray[options.get(choice-1)[1]].decreaseLessonAttendance(options.get(choice-1)[2]);
                // remove the students name from the list of attendees for this Lesson on this day
                schedule.scheduleArray[options.get(choice-1)[1]].removeStudent(options.get(choice-1)[2], options.get(choice-1)[3]);
            }
        }

        // Print message to confirm lesson booking has been cancelled.
        System.out.println("You have been removed from " + schedule.scheduleArray[options.get(choice-1)[1]].getLessonName() + " on " + schedule.getOpenDays(options.get(choice-1)[2]) + " at " + schedule.scheduleArray[options.get(choice-1)[1]].getLessonTime() + ":00");// Print lessons

        // Give user the opportunity to book another lesson
        System.out.println("\nWould you like to book another lesson:\n1 : Yes\n2 : No");

        int reBookChoice = dataInputValidation(1, 2); // Test for valid user input and save input
        if (reBookChoice == -1){showMenu(schedule, customerList);} // redirect after error
        return reBookChoice;
    }


}


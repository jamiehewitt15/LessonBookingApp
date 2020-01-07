package com.company;

import java.util.ArrayList;
import java.util.Scanner; // import the Scanner class

import static com.company.Customer.customerList;
import static com.company.Customer.login; // import the login() method from the Customer class
import static com.company.Rating.ratingString; // import the ratingString() method from the Rating class
import static com.company.Report.*; // import all methods from the Report class
import static com.company.Schedule.*; // import all methods from the Schedule class


public class Menu {

    private static String[] menuOptions = { "Book Lesson", "Enter review",
                                            "Show Report",  "Change user",
                                            "Cancel Lesson booking", "Show my bookings",
                                            "Close programme" };

    static void menu() {

        System.out.println("\nEnter the number to select:\n");
        int optionCount = 1;
        for (String i : menuOptions) { // Looping through menuOptions array to show the menu
            System.out.println(optionCount +" : "+i); // Print menu options.
            optionCount++;
        }

        Scanner menuInput = new Scanner(System.in);  // Create a Scanner object

        // Test for valid user input
        DataValidator menuInputTest = new DataValidator(1, menuOptions.length);  // Create a DataValidator object
        if(menuInput.hasNextInt()) {} else {menuInputTest.errorMessage();} // Test if input is an integer
        Integer menuSelect = menuInput.nextInt(); // Saving input as an integer
        menuInputTest.testBoundary(menuSelect); // Test if input is within the boundary

        switch(menuSelect) {
            case 1: // book a lesson
                bookLesson(); // run bookLesson() method from Schedule
                menu();
                break;
            case 2:

                System.out.println("\nWhich Lesson would you like to review?\n");// code block
                int lessonCount = 1;
                for (Lesson lessonObject : schedule) {
                    System.out.println(lessonCount +": "+ lessonObject.getLessonName() ); // Show options for days when lessons can be booked.
                    lessonCount++;
                }

                // Test for valid user input
                Scanner lessonScan = new Scanner(System.in);  // Create a Scanner object
                DataValidator lessonRatingValid = new DataValidator(1, schedule.length);  // Create a DataValidator object
                if(lessonScan.hasNextInt()) {} else {lessonRatingValid.errorMessage();} // Test if input is an integer
                Integer ratingSelect = lessonScan.nextInt() - 1; // Saving input as an integer
                lessonRatingValid.testBoundary((ratingSelect + 1)); // Test if input is within the boundary


                System.out.println("\nPlease type your review (1-5)\n1: Very dissatisfied\n2: Dissatisfied\n3: Ok\n4: Satisfied\n5: Very Satisfied");// code block

                // Test for valid user input
                Scanner ratingScan = new Scanner(System.in);  // Create a Scanner object
                DataValidator ratingInputValid = new DataValidator(1, 5);  // Create a DataValidator object
                if(ratingScan.hasNextInt()) {} else {ratingInputValid.errorMessage();} // Test if input is an integer
                Integer ratingInput = ratingScan.nextInt(); // Saving input as an integer
                ratingInputValid.testBoundary(ratingInput); // Test if input is within the boundary

                schedule[ratingSelect].getRating().addRating(ratingInput); // Add the rating and update the average.

                System.out.println("\nThank you for your review.\nYou have rated " + schedule[ratingSelect].getLessonName() + " " + ratingInput + " out of 5\n");// Show rating in output
                ratingString(ratingSelect);

                menu();
                break;

            case 3: // Option for reports

                // Sub-menu for the type of report
                System.out.println("\nWhat type of report would you like?");
                int reportOptionCount = 1;
                for (String i : availableReports) { // Looping through availableReports array to show the menu
                    System.out.println(reportOptionCount +" : "+i); // Print report options.
                    reportOptionCount++;
                }

                // Test for valid user input
                Scanner reportScan = new Scanner(System.in);  // Create a Scanner object
                DataValidator reportInputValid = new DataValidator(1, 3);  // Create a DataValidator object
                if(reportScan.hasNextInt()) {} else {reportInputValid.errorMessage();} // Test if input is an integer
                int reportChoice = reportScan.nextInt(); // Saving input as an integer
                reportInputValid.testBoundary(reportChoice); // Test if input is within the boundary

                // Switch statement selects the different report options
                switch (reportChoice){
                    case 1:
                        earningsReport();
                        break;
                    case 2:
                        attendanceReport();
                        break;
                    case 3:
                        ratingReport();
                        break;
                }

                menu();

                break;
            case 4: // Change user
                System.out.println("Welcome!");// code block
                login();
                menu();
                break;
            case 5: // Change booking
                System.out.println("\nSelect the booking you would like to cancel and then book another lesson:");// code block

                ArrayList<int[]> deleteOptions = new ArrayList<int[]>(); // Create an ArrayList object to store all of the options
                int count = 1; // count how many options there are
                // print all of the lessons that the current student is enrolled in
                for (int i = 0; i < schedule.length; ++i) {
                    for (int j = 0; j < schedule[i].getLessonStudents().length; ++j) {
                        for (int k = 0; k < lessonCapacity; ++k) {
                            if (schedule[i].getLessonStudents(j, k) == customerList.get(customerList.size() - 1)){
                                System.out.println(count + " : " + schedule[i].getLessonName() + " on " + getOpenDays(j) + " at " + schedule[i].getLessonTime() + ":00");// Print lessons
                                deleteOptions.add(new int[]{count, i, j, k}); // add the available lessons to the deleteOptions array List
                                count++;
                            }

                        }
                    }
                }

                // Test for valid user input
                Scanner deleteScan = new Scanner(System.in);  // Create a Scanner object
                DataValidator deleteInputValid = new DataValidator(1, (schedule.length*8* maxLessonsPerDay));  // Create a DataValidator object
                if(deleteScan.hasNextInt()) {} else {deleteInputValid.errorMessage();} // Test if input is an integer
                int deleteChoice = deleteScan.nextInt(); // Saving input as an integer
                deleteInputValid.testBoundary(deleteChoice); // Test if input is within the boundary

                for (int i = 0; i < deleteOptions.size(); ++i) {
                   if(deleteChoice == deleteOptions.get(deleteChoice-1)[0]){
                       // decrease the total attendance count for the selected lesson
                       schedule[deleteOptions.get(deleteChoice-1)[1]].decreaseTotalAttendance();
                       // decrease the attendance count for the selected lesson on the specific name
                       schedule[deleteOptions.get(deleteChoice-1)[1]].decreaseLessonAttendance(deleteOptions.get(deleteChoice-1)[2]);
                       // remove the students name from the list of attendees for this Lesson on thi day
                       schedule[deleteOptions.get(deleteChoice-1)[1]].removeStudent(deleteOptions.get(deleteChoice-1)[2], deleteOptions.get(deleteChoice-1)[3]);
                   }
                }

                // Print message to confirm lesson booking has been cancelled.
                System.out.println("You have been removed from " + schedule[deleteOptions.get(deleteChoice-1)[1]].getLessonName() + " on " + getOpenDays(deleteOptions.get(deleteChoice-1)[1]) + " at " + schedule[deleteOptions.get(deleteChoice-1)[1]].getLessonTime() + ":00");// Print lessons
                // Give user the opportunity to book another lesson
                System.out.println("\nWould you like to book another lesson:\n1 : Yes\n2 : No");

                Scanner reBookScan = new Scanner(System.in);  // Create a Scanner object
                // Test for valid user input
                DataValidator reBookInputValid = new DataValidator(1, 2);  // Create a DataValidator object
                if(reBookScan.hasNextInt()) {} else {reBookInputValid.errorMessage();} // Test if input is an integer
                int reBookChoice = reBookScan.nextInt(); // Saving input as an integer
                reBookInputValid.testBoundary(reBookChoice); // Test if input is within the boundary

                switch (reBookChoice){
                    case 1:
                        bookLesson(); // book another lesson
                        menu();
                        break;

                    case 2:
                        menu();
                }



                break;
            case 6: // Show booked lessons
                System.out.println("Booked lessons for user: " + customerList.get(customerList.size() - 1));
                for (int i = 0; i < schedule.length; ++i) {
                    for (int j = 0; j < schedule[i].getLessonStudents().length; ++j) {
                        for (int k = 0; k < lessonCapacity; ++k) {
                            if (schedule[i].getLessonStudents(j, k) == customerList.get(customerList.size() - 1)){
                                System.out.println(schedule[i].getLessonName() + " on " + getOpenDays(j) + " at " + schedule[i].getLessonTime() + ":00");// Print lessons

                            }

                        }
                    }
                }
                menu();
                break;
            case 7: // Option to quit
                quit();
                break;
            default:  // Default option provides redundancy as the data validator should stop other input.
                System.out.println("Sorry that command isn't recognised"); // print message
                menu();
        }
    }

    static void quit(){
        System.out.println("\n\nAre you sure you would like to quit?\nYou may lose unsaved information\n1 : Show main menu\n2 : Exit");  // Output user input
        Scanner menuInput = new Scanner(System.in);  // Create a Scanner object

        DataValidator menuInputTest = new DataValidator(1,2);  // Create a DataValidator object
        if(menuInput.hasNextInt()) {} else {menuInputTest.errorMessage();} // Test if input is an integer
        Integer menuSelect = menuInput.nextInt(); // Saving input as an integer
        menuInputTest.testBoundary(menuSelect); // Test if input is within the boundary

        switch(menuSelect) {
            case 1:
                menu();
                break;
            case 2:
                System.out.println("Thank you, goodbye!");// code block
                break;
            default:
                System.out.println("Sorry that command isn't recognised"); // code block
                menu();
        }
    }
}

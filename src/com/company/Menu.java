package com.company;

import java.util.Scanner; // import the Scanner class
import static com.company.Customer.login; // import the login() method from the Customer class
import static com.company.Rating.ratingString; // import the ratingString() method from the Rating class
import static com.company.Report.*; // import all methods from the Report class
import static com.company.Schedule.*; // import all methods from the Schedule class


public class Menu {

    static void menu() {

        System.out.println("\nEnter the number to select:\n1 : Book Class\n2 : Enter review\n3 : Show Report\n4 : Change user\n5 : Close programme");  // Output user input
        Scanner menuInput = new Scanner(System.in);  // Create a Scanner object

        // Test for valid user input
        DataValidator menuInputTest = new DataValidator(1,5);  // Create a DataValidator object
        if(menuInput.hasNextInt()) {} else {menuInputTest.errorMessage();} // Test if input is an integer
        Integer menuSelect = menuInput.nextInt(); // Saving input as an integer
        menuInputTest.testBoundary(menuSelect); // Test if input is within the boundary

        switch(menuSelect) {
            case 1: // book a class
                book(); // run book() method from Schedule
                menu();
                break;
            case 2:

                System.out.println("\nWhich class would you like to review?\n");// code block
                int classCount = 1;
                for (Class classObject : schedule) {
                    System.out.println(classCount +": "+ classObject.getClassName() ); // Show options for days when classes can be booked.
                    classCount++;
                }

                // Test for valid user input
                Scanner classScan = new Scanner(System.in);  // Create a Scanner object
                DataValidator classRatingValid = new DataValidator(1, schedule.length);  // Create a DataValidator object
                if(classScan.hasNextInt()) {} else {classRatingValid.errorMessage();} // Test if input is an integer
                Integer ratingSelect = classScan.nextInt() - 1; // Saving input as an integer
                classRatingValid.testBoundary((ratingSelect + 1)); // Test if input is within the boundary


                System.out.println("\nPlease type your review (1-5)\n1: Very dissatisfied\n2: Dissatisfied\n3: Ok\n4: Satisfied\n5: Very Satisfied");// code block

                // Test for valid user input
                Scanner ratingScan = new Scanner(System.in);  // Create a Scanner object
                DataValidator ratingInputValid = new DataValidator(1, 5);  // Create a DataValidator object
                if(ratingScan.hasNextInt()) {} else {ratingInputValid.errorMessage();} // Test if input is an integer
                Integer ratingInput = ratingScan.nextInt(); // Saving input as an integer
                ratingInputValid.testBoundary(ratingInput); // Test if input is within the boundary

                schedule[ratingSelect].getRating().addRating(ratingInput); // Add the rating and update the average.

                System.out.println("\nThank you for your review.\nYou have rated " + schedule[ratingSelect].getClassName() + " " + ratingInput + " out of 5\n");// Show rating in output
                ratingString(ratingSelect);

                menu();
                break;

            case 3: // Option for reports

                // Sub-menu for the type of report
                System.out.println("\nWhat type of report would you like?\n1: Highest earning classes\n2: Attendance report\n3: Average class ratings");

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
            case 5: // Option to quit
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

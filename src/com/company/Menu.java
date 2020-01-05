package com.company;

import java.util.Scanner;
import static com.company.Customer.login;
import static com.company.Rating.ratingString;
import static com.company.Schedule.*;


public class Menu {

    static void menu() {

        System.out.println("\nEnter the number to select:\n1 : Book Class\n2 : Enter review\n3 : Show Report\n4 : Change user\n5 : Close programme");  // Output user input
        Scanner menuInput = new Scanner(System.in);  // Create a Scanner object

        DataValidator menuInputTest = new DataValidator(1,5);  // Create a DataValidator object
        if(menuInput.hasNextInt()) {} else {menuInputTest.errorMessage();} // Test if input is an integer
        Integer menuSelect = menuInput.nextInt(); // Saving input as an integer
        menuInputTest.testBoundary(menuSelect); // Test if input is within the boundary

        switch(menuSelect) {
            case 1:
                book();
                repeatMenu();
                break;
            case 2:

                System.out.println("\nWhich class would you like to review?\n");// code block
                int classCount = 1;
                for (Class classObject : schedule) {
                    System.out.println(classCount +": "+ classObject.getClassName() ); // Show options for days when classes can be booked.
                    classCount++;
                }

                Scanner classScan = new Scanner(System.in);  // Create a Scanner object
                DataValidator classRatingValid = new DataValidator(1, schedule.length);  // Create a DataValidator object
                if(classScan.hasNextInt()) {} else {classRatingValid.errorMessage();} // Test if input is an integer
                Integer ratingSelect = classScan.nextInt() - 1; // Saving input as an integer
                classRatingValid.testBoundary((ratingSelect + 1)); // Test if input is within the boundary


                System.out.println("\nPlease type your review (1-5)\n1: Very dissatisfied\n2: Dissatisfied\n3: Ok\n4: Satisfied\n5: Very Satisfied");// code block


                Scanner ratingScan = new Scanner(System.in);  // Create a Scanner object
                DataValidator ratingInputValid = new DataValidator(1, 5);  // Create a DataValidator object
                if(ratingScan.hasNextInt()) {} else {ratingInputValid.errorMessage();} // Test if input is an integer
                Integer ratingInput = ratingScan.nextInt(); // Saving input as an integer
                ratingInputValid.testBoundary(ratingInput); // Test if input is within the boundary

                schedule[ratingSelect].getRating().addRating(ratingInput); // Add the rating and update the average.

                System.out.println("\nThank you for your review.\nYou have rated " + schedule[ratingSelect].getClassName() + " " + ratingInput + " out of 5");// Show rating in output
                ratingString(ratingSelect);

                repeatMenu();
                break;
            case 3:
                System.out.println("What type of report would you like?");


                System.out.println("Class attendance is shown below");//
                for (int i = 0; i < openDays.length; i++) {
                    int count = 1;
                    System.out.println("\nClass attendance on: " + openDays[i]); // Show options for days when classes can be booked.
                    for (int j = 0; j < schedule.length; j++) {
                        if ((schedule[j].getClassDay(i) == true) && (count <= MaxClassesPerDay)) {
                            System.out.println(schedule[j].getClassName() + ": " + schedule[j].getClassAttendance(i) );
                            count++;
                        }

                    }

                }
                repeatMenu();

                break;
            case 4:
                System.out.println("Welcome!");// code block
                login();
                menu();
                break;
            case 5:
                System.out.println("Thank you, goodbye!");// code block

                break;
            default:
                System.out.println("Sorry that command isn't recognised"); // code block
                menu();
        }
    }

    static void repeatMenu(){
        System.out.println("\nWould you like to continue?\n1 : Show main menu\n2 : Exit");  // Output user input
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

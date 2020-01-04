package com.company;

import java.util.Scanner;
import static com.company.Customer.login;
import static com.company.Schedule.*;

public class Menu {

    static void menu() {

        System.out.println("\nEnter the number to select:\n1 : Book Class\n2 : Enter review\n3 : Show Report\n4 : Change user\n5 : Close programme");  // Output user input
        Scanner menuInput = new Scanner(System.in);  // Create a Scanner object
        Integer menuSelect = menuInput.nextInt();
        switch(menuSelect) {
            case 1:
                book();
                repeatMenu();
                break;
            case 2:
                System.out.println("Please type your review");// code block
                System.out.println("Thank you for your review");// code block
                repeatMenu();
                break;
            case 3:
                System.out.println("Class attendance is shown below");//
                for (int i = 0; i < openDays.length; i++) {
                    int count = 1;
                    System.out.println("\n" + openDays[i]); // Show options for days when classes can be booked.
                    for (int j = 0; j < schedule.length; j++) {
                        if ((schedule[j].getClassDay(i) == true) && (count <= MaxClassesPerDay)) {
                            System.out.println(schedule[j].getClassName() + " attendance: " + schedule[j].getClassAttendance(i) );
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
        String menuSelect = menuInput.nextLine();
        switch(menuSelect) {
            case "1":
                menu();
                break;
            case "2":
                System.out.println("Thank you, goodbye!");// code block
                break;
            default:
                System.out.println("Sorry that command isn't recognised"); // code block
                menu();
        }
    }
}

package com.company;

import java.util.Scanner;

public class DataValidator {
    private int lowerBoundary = 0; // initialising lower boundary variable
    private int upperBoundary = 15; // initialising upper boundary variable

    // DataValidator constructor. Upper and lower boundaries are required parameters.
    public DataValidator(int i, int j){
    this.setLowerBoundary(i);
    this.setUpperBoundary(j);
    }

    public void setLowerBoundary(int i) { this.lowerBoundary = i; } // set the lower boundary for testing
    public void setUpperBoundary(int j)
    {
        this.upperBoundary = j;
    } // set the upper boundary for testing

    // Test if the input falls between the boundaries
    private int testBoundary(int x){
        if (x >= lowerBoundary && x <= upperBoundary){
            return x;
        } else {
            errorMessage();
            return -1; // returns -1 if input is outside the boundary
        }
    }

    // Print error message
    private int errorMessage(){
        System.out.println("Invalid Input\nAn integer is required between " + lowerBoundary + " and " + upperBoundary);
        return -1;
    }

    public static int dataInputValidation(int lowerBound, int upperBound){
        Scanner menuInput = new Scanner(System.in);  // Create a Scanner object
        DataValidator menuInputTest = new DataValidator(lowerBound, upperBound);  // Create a DataValidator object
        int menuSelect;
        if(menuInput.hasNextInt()) {
            menuSelect = menuInput.nextInt(); // Saving input as an integer
            menuSelect = menuInputTest.testBoundary(menuSelect); // Test if input is within the boundary
        } else {
            menuSelect = menuInputTest.errorMessage(); } // Test if input is an integer

        return menuSelect; // returns -1 if input is outside the boundary
    }
}

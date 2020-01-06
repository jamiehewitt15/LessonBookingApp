package com.company;

import static com.company.Menu.menu;

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
    public void testBoundary(int x){
        if (x >= lowerBoundary && x <= upperBoundary){ } else {
            errorMessage();
        }
    }

    // Print error message
    public void errorMessage(){
        System.out.println("Invalid Input\nAn integer is required between " + lowerBoundary + " and " + upperBoundary);
        menu();
    }
}

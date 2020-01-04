package com.company;

import static com.company.Menu.menu;
import java.util.Scanner;

public class DataValidator {
    private int lowerBoundary = 0;
    private int upperBoundary = 15;

    public DataValidator(int i, int j){
    this.setLowerBoundary(i);
    this.setUpperBoundary(j);
    }

    public void setLowerBoundary(int i) { this.lowerBoundary = i; }
    public void setUpperBoundary(int j)
    {
        this.upperBoundary = j;
    }

    public void testInteger(String x){
        try{
            int y = Integer.parseInt(x);
        }catch (NumberFormatException ex) {
            //handle exception here
            System.out.println("Invalid Input\nAn integer is require between " + lowerBoundary + " and " + upperBoundary);
            menu();
        }
    }

    public void errorMessage(){
        System.out.println("Invalid Input\nAn integer is required between " + lowerBoundary + " and " + upperBoundary);
        menu();
    }

    public void testBoundary(int x){
        if (x <= lowerBoundary && x <= upperBoundary){ } else {
            errorMessage();
        }
    }
}

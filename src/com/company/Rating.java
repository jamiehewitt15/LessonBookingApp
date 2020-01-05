package com.company;

import java.util.ArrayList; // import the ArrayList class
import static com.company.Menu.menu;
import static com.company.Schedule.schedule;

public class Rating {
    ArrayList<Integer> ratings = new ArrayList<Integer>(); // Create an ArrayList object
    private double average = 0;
    private int numOfRatings = 0;

    public Rating(){
        this.average = 0;
        this.ratings =  new ArrayList<Integer>();
    }

    public int getNumOfRatings(){ return ratings.size(); }
    public double getAverage(){ return average; }

    public void addRating(int x){
        if (x <= 5 && x >= 1){
            ratings.add(x);
            setAverage();
        } else {
            System.out.println("Invalid Input\nAn integer is required between 1 and 5");
            menu();
        }
    }

    public void setAverage(){
        Integer sum = 0;
        for (Integer rating : ratings) {
            sum += rating;
        }
        this.average = sum / ratings.size(); }

    public static void ratingString(int x){
        System.out.println(schedule[x].getClassName() + " has an average rating of " + schedule[x].getRating().getAverage() + " after " + schedule[x].getRating().getNumOfRatings() + " reviews.");
    }

}


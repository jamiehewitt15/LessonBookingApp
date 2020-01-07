package com.company;

import java.util.ArrayList; // import the ArrayList class
import static com.company.Menu.menu; // import the menu() method from the Menu class
import static com.company.Schedule.schedule; // import the schedule[] array from the Schedule class

public class Rating {
    ArrayList<Integer> ratings = new ArrayList<Integer>(); // Create an ArrayList object to store all of the ratings
    private double average = 0; // Storing the average rating so it is more easily retrieved.

    public Rating(){
        this.average = 0;
        this.ratings =  new ArrayList<Integer>();
    }

    public int getNumOfRatings(){ return ratings.size(); }
    public double getAverage(){ return average; }

    // method to add rating to arrayList
    public void addRating(int x){
        if (x <= 5 && x >= 1){
            ratings.add(x);
            setAverage();
        } else {
            System.out.println("Invalid Input\nAn integer is required between 1 and 5");
            menu();
        }
    }

    // method to calculate the average rating
    public void setAverage(){
        Integer sum = 0;
        for (Integer rating : ratings) {
            sum += rating;
        }
        this.average = sum / getNumOfRatings(); }

    // method print the name of the class, average rating and the number of reviews.
    public static void ratingString(int x){
        System.out.println(schedule[x].getLessonName() + "\n\t->\tAverage rating: " + schedule[x].getRating().getAverage() + " | Number of reviews: " + schedule[x].getRating().getNumOfRatings() + " reviews.");
    }

}


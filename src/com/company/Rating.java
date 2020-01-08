package com.company;

import java.util.ArrayList; // import the ArrayList lesson

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
    public boolean addRating(int x){
        if (x <= 5 && x >= 1){
            ratings.add(x);
            setAverage();
            return true;
        } else {
            System.out.println("Invalid Input\nAn integer is required between 1 and 5");
            return false;
        }
    }

    // method to calculate the average rating
    public void setAverage(){
        Integer sum = 0;
        for (Integer rating : ratings) {
            sum += rating;
        }
        this.average = sum / getNumOfRatings(); }

    // method print the name of the lesson, average rating and the number of reviews.
    public void ratingString(int x, Schedule schedule){
        System.out.println(schedule.scheduleArray[x].getLessonName() + "\n\t->\tAverage rating: " + schedule.scheduleArray[x].getRating().getAverage() + " | Number of reviews: " + schedule.scheduleArray[x].getRating().getNumOfRatings() + " reviews.");
    }

}


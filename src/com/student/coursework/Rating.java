package com.student.coursework;

// Programming and Program Design
// Student Number: 18023219

import java.util.ArrayList; // import the ArrayList lesson

public class Rating {
    ArrayList<Integer> ratingsArray = new ArrayList<Integer>(); // Create an ArrayList object to store all of the ratings
    private double averageRating = 0; // Storing the average rating so it is more easily retrieved.
    private int maxRating = 5; //  the maximum valid rating.
    private int minRating = 1; //  the minimum valid rating.

    public Rating(){
        this.averageRating = 0;
        this.ratingsArray =  new ArrayList<Integer>();
    }

    public int getNumOfRatings(){ return ratingsArray.size(); }
    public double getAverageRating(){ return averageRating; }

    // method to add rating to arrayList
    public boolean addRating(int rating){
        if (rating <= maxRating && rating >= minRating){
            ratingsArray.add(rating);
            setAverage();
            return true;
        } else {
            System.out.println("Invalid Input\nAn integer is required between 1 and 5");
            return false;
        }
    }

    // method to calculate the average rating
    private void setAverage(){
        double sum = 0;
        for (Integer rating : ratingsArray) {
            sum += rating;
        }
        this.averageRating = sum / getNumOfRatings(); }

    // method print the name of the lesson, average rating and the number of reviews.
    public void ratingString(int x, Schedule schedule){
        System.out.println(schedule.scheduleArray[x].getLessonName() + "\n\t->\tAverage rating: " + schedule.scheduleArray[x].getRating().getAverageRating() + " | Number of reviews: " + schedule.scheduleArray[x].getRating().getNumOfRatings() + " reviews.");
    }



}


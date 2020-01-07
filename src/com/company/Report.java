package com.company;


import static com.company.Rating.ratingString;
import static com.company.Schedule.*;

public class Report {

    public static String[] availableReports = { "Highest earning classes", "Attendance report", "Average class ratings" };

    public static void earningsReport() {

        // Find the class with the highest earnings
        Lesson highestEarning = schedule[0];
        for (int i = 1; i < schedule.length; i++) {
            if(highestEarning.getEarnings() < schedule[i].getEarnings() ){
                highestEarning = schedule[i];
            };
        }

        // Check if the highest is zero, otherwise print it out
        if(highestEarning.getEarnings() == 0){
            System.out.println("\nNo class has any income.\n____________________");//
        } else{
            System.out.println("\nThe class with the highest income is: " + highestEarning.getLessonName() + "\nIncome: £" + highestEarning.getEarnings() + "\n____________________");//
        }

        // Print total earnings for each class
        for (int i = 0; i < schedule.length; i++) {
            System.out.println(schedule[i].getLessonName() + " - Total Earnings: £" + schedule[i].getEarnings()) ;
        }
    }

    public static void ratingReport() {
        System.out.println("\nAverage Rating Report\n____________________");//

        // Find the class with the highest rating
        Lesson highestRating = schedule[0];
        for (int i = 1; i < schedule.length; i++) {
            if(highestRating.getRating().getAverage() < schedule[i].getRating().getAverage()){
                highestRating = schedule[i];
            };
        }

        // Check if the highest is zero, otherwise print it out
        if(highestRating.getRating().getAverage() == 0){
            System.out.println("\nThere have been no ratings\n____________________");//
        } else{
            System.out.println("\nThe highest rated class is " + highestRating.getLessonName() + ": " + highestRating.getRating().getAverage() + " out of 5 (" + highestRating.getRating().getNumOfRatings() + " ratings)" + "\n____________________");//
        }

        // Print average rating for each class
        for (int i = 0; i < schedule.length; i++) {
            ratingString(i);
        }
    }

    public static void attendanceReport() {

        // Find the class with the highest total attendance
        Lesson highestAttendance = schedule[0];
        for (int i = 1; i < schedule.length; i++) {
            if(highestAttendance.getTotalAttendance() < schedule[i].getTotalAttendance() ){
                highestAttendance = schedule[i];
            };
        }

        // Check if the highest is zero, otherwise print it out
        if(highestAttendance.getTotalAttendance() == 0){
            System.out.println("*************************************\nNo classes have been attended.\n*************************************");//
        } else{
            System.out.println("**************************************************************************\nThe class with the most attendance is " + highestAttendance.getLessonName() + "\nTotal attendance: " + highestAttendance.getTotalAttendance() + "\n**************************************************************************");//
        }

        // Print attendance for each class on each day
        for (int i = 0; i < getOpenDays().length; i++) {
            int count = 1;
            System.out.println("\n\nClass attendance on: " + getOpenDays(i) ); // Show options for days when classes can be booked.
            for (int j = 0; j < schedule.length; j++) {
                // Check the class is on that day and the max attendance has not been exceeded
                if ((schedule[j].getClassDay(i) == true) && (count <= maxLessonsPerDay)) {
                    System.out.print(schedule[j].getLessonName() + ": " + schedule[j].getClassAttendance(i) + " | " );
                    count++;
                }

            }

        }
    }
}

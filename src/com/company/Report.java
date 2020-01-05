package com.company;


import static com.company.Rating.ratingString;
import static com.company.Schedule.*;

public class Report {
    private String[] reportTypes = {"Highest earning classes", "Full attendance report", "Average class ratings"};

    public static void earningsReport() {

        Class highestEarning = schedule[0];
        for (int i = 1; i < schedule.length; i++) {
            if(highestEarning.getEarnings() < schedule[i].getEarnings() ){
                highestEarning = schedule[i];
            };
        }

        if(highestEarning.getEarnings() == 0){
            System.out.println("\nNo class has any income.\n____________________");//
        } else{
            System.out.println("\nThe class with the highest income is: " + highestEarning.getClassName() + "\nIncome: £" + highestEarning.getEarnings() + "\n____________________");//
        }

        for (int i = 0; i < schedule.length; i++) {
            System.out.println(schedule[i].getClassName() + " - Total Earnings: £" + schedule[i].getEarnings()) ;
        }
    }

    public static void ratingReport() {
        System.out.println("\nAverage Rating Report\n____________________");//
        Class highestRating = schedule[0];
        for (int i = 1; i < schedule.length; i++) {
            if(highestRating.getRating().getAverage() < schedule[i].getRating().getAverage()){
                highestRating = schedule[i];
            };
        }

        if(highestRating.getRating().getAverage() == 0){
            System.out.println("\nThere have been no ratings\n____________________");//
        } else{
            System.out.println("\nThe highest rated class is " + highestRating.getClassName() + ": " + highestRating.getRating().getAverage() + " out of 5 (" + highestRating.getRating().getNumOfRatings() + " ratings)" + "\n____________________");//
        }


        for (int i = 0; i < schedule.length; i++) {
            ratingString(i);
        }
    }

    public static void attendanceReport() {

        Class highestAttendance = schedule[0];
        for (int i = 1; i < schedule.length; i++) {
            if(highestAttendance.getTotalAttendance() < schedule[i].getTotalAttendance() ){
                highestAttendance = schedule[i];
            };
        }
        if(highestAttendance.getTotalAttendance() == 0){
            System.out.println("*************************************\nNo classes have been attended.\n*************************************");//
        } else{
            System.out.println("**************************************************************************\nThe class with the most attendance is " + highestAttendance.getClassName() + "\nTotal attendance: " + highestAttendance.getTotalAttendance() + "\n**************************************************************************");//
        }


        for (int i = 0; i < openDays.length; i++) {
            int count = 1;
            System.out.println("\n\nClass attendance on: " + openDays[i] ); // Show options for days when classes can be booked.
            for (int j = 0; j < schedule.length; j++) {
                if ((schedule[j].getClassDay(i) == true) && (count <= MaxClassesPerDay)) {
                    System.out.print(schedule[j].getClassName() + ": " + schedule[j].getClassAttendance(i) + " | " );
                    count++;
                }

            }

        }
    }
}

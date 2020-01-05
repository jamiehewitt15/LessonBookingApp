package com.company;


import static com.company.Rating.ratingString;
import static com.company.Schedule.*;

public class Report {
    private String[] reportTypes = {"Highest earning classes", "Full attendance report", "Average class ratings"};

    public static void ratingReport() {
        System.out.println("\nAverage Rating Report\n____________________");//
        for (int i = 0; i < schedule.length; i++) {
            ratingString(i);
        }
    }

    public static void attendanceReport() {
        System.out.println("\nClass attendance is shown below");//
        for (int i = 0; i < openDays.length; i++) {
            int count = 1;
            System.out.println("\n\nClass attendance on: " + openDays[i]); // Show options for days when classes can be booked.
            for (int j = 0; j < schedule.length; j++) {
                if ((schedule[j].getClassDay(i) == true) && (count <= MaxClassesPerDay)) {
                    System.out.print(schedule[j].getClassName() + ": " + schedule[j].getClassAttendance(i) + " | " );
                    count++;
                }

            }

        }
    }
}

package com.company;

public class Report {

    public String[] availableReports = { "Highest earning lessons", "Attendance report", "Average lesson ratings" };

    public String[] getAvailableReports() { return availableReports; }

    public void earningsReport(Schedule schedule) {

        // Find the lesson with the highest earnings
        Lesson highestEarning = schedule.scheduleArray[0];
        for (int i = 1; i < schedule.scheduleArray.length; i++) {
            if(highestEarning.getEarnings() < schedule.scheduleArray[i].getEarnings() ){
                highestEarning = schedule.scheduleArray[i];
            };
        }

        // Check if the highest is zero, otherwise print it out
        if(highestEarning.getEarnings() == 0){
            System.out.println("\nNo lesson has any income.\n____________________");//
        } else{
            System.out.println("\nThe lesson with the highest income is: " + highestEarning.getLessonName() + "\nIncome: £" + highestEarning.getEarnings() + "\n____________________");//
        }

        // Print total earnings for each lesson
        for (int i = 0; i < schedule.scheduleArray.length; i++) {
            System.out.println(schedule.scheduleArray[i].getLessonName() + " - Total Earnings: £" + schedule.scheduleArray[i].getEarnings()) ;
        }
    }

    public void ratingReport(Schedule schedule) {
        System.out.println("\nAverage Rating Report\n____________________");//

        // Find the lesson with the highest rating
        Lesson highestRating = schedule.scheduleArray[0];
        for (int i = 1; i < schedule.scheduleArray.length; i++) {
            if(highestRating.getRating().getAverageRating() < schedule.scheduleArray[i].getRating().getAverageRating()){
                highestRating = schedule.scheduleArray[i];
            };
        }

        // Check if the highest is zero, otherwise print it out
        if(highestRating.getRating().getAverageRating() == 0){
            System.out.println("\nThere have been no ratings\n____________________");//
        } else{
            System.out.println("\nThe highest rated lesson is " + highestRating.getLessonName() + ": " + highestRating.getRating().getAverageRating() + " out of 5 (" + highestRating.getRating().getNumOfRatings() + " ratings)" + "\n____________________");//
        }

        // Print average rating for each lesson
        for (int i = 0; i < schedule.scheduleArray.length; i++) {
            Rating newRating = new Rating();
            newRating.ratingString(i, schedule);
        }
    }

    public void attendanceReport(Schedule schedule) {

        // Find the lesson with the highest total attendance
        Lesson highestAttendance = schedule.scheduleArray[0];
        for (int i = 1; i < schedule.scheduleArray.length; i++) {
            if(highestAttendance.getTotalAttendance() < schedule.scheduleArray[i].getTotalAttendance() ){
                highestAttendance = schedule.scheduleArray[i];
            };
        }

        // Check if the highest is zero, otherwise print it out
        if(highestAttendance.getTotalAttendance() == 0){
            System.out.println("*************************************\nNo lessons have been attended.\n*************************************");//
        } else{
            System.out.println("**************************************************************************\nThe lesson with the most attendance is " + highestAttendance.getLessonName() + "\nTotal attendance: " + highestAttendance.getTotalAttendance() + "\n**************************************************************************");//
        }

        // Print attendance for each lesson on each day
        for (int i = 0; i < schedule.getOpenDaysArray().length; i++) {
            int count = 1;
            System.out.println("\n\nLesson attendance on: " + schedule.getOpenDays(i) ); // Show options for days when lessons can be booked.
            for (int j = 0; j < schedule.scheduleArray.length; j++) {
                // Check the lesson is on that day and the max attendance has not been exceeded
                if ((schedule.scheduleArray[j].getLessonDay(i) == true) && (count <= schedule.maxLessonsPerDay)) {
                    System.out.print(schedule.scheduleArray[j].getLessonName() + ": " + schedule.scheduleArray[j].getLessonAttendance(i) + " | " );
                    count++;
                }

            }

        }
    }
}

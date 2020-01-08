package com.company;

import static com.company.CustomerList.currentUser;
import static com.company.Schedule.lessonCapacity;

public class Lesson {
    private String lessonName; // Name of the ETC lesson.
    private int lessonTime = 0; // Time of day that the lesson runs.
    private int lessonPrice = 20; // cost of attending the lesson
    private boolean[] lessonDay = {false, false, false, false, false, false, false, false}; // Timetable of days when lesson is running
    private int[] lessonAttendance = {0, 0, 0, 0, 0, 0, 0, 0}; // attendance count for the lesson on each day
    private Rating ratings; // Ratings object for the lesson
    private int totalAttendance = 0; // total lesson attendance on all days combined
    private int earnings = 0; // Earnings from the lesson = lessonPrice * totalAttendance
    private String[][] lessonStudents = new String[8][lessonCapacity]; // Create array to store the names of students enrolled in lesson


    // Lesson constructor
    public Lesson(String name, int time, int price, boolean[] day) {
        this.setLessonName(name);
        this.setLessonTime(time);
        this.setLessonPrice(price);
        this.setDay(day);
        this.ratings = new Rating();
    }

    // Lesson set methods
    public void setLessonName(String name)
    {
        this.lessonName = name;
    }
    public void setLessonTime(int time)
    {
        this.lessonTime = time;
    }
    public void setLessonPrice(int price)
    {
        this.lessonPrice = price;
    }
    public void setDay(boolean[] day) { this.lessonDay = day; }
    public void increaseLessonAttendance(int i) { this.lessonAttendance[i]++; }
    public void decreaseLessonAttendance(int i) { this.lessonAttendance[i]--; }
    public void setTotalAttendance(){this.totalAttendance++; }
    public void decreaseTotalAttendance(){this.totalAttendance--; }
    public void setEarnings(){this.earnings = this.totalAttendance * lessonPrice; }
    public void setRating(Rating i){ this.ratings = i; }
    public void removeStudent(int i, int j){ this.lessonStudents[i][j] = "";}
    public void setLessonStudents(int i){
        int j;
        if (getLessonAttendance(i) < lessonCapacity) { // Check that the lesson is not already full
            j = getLessonAttendance(i);
            this.lessonStudents[i][j] = currentUser.getName();} // Add the current student's name to the LessonStudents[][] array
        else { System.out.println("Sorry, Lesson is full.");}
        }

    // Lesson get methods
    public boolean getLessonDay(int i) { return this.lessonDay[i]; }
    public int getLessonAttendance(int i) { return this.lessonAttendance[i]; }
    public String getLessonName() { return lessonName; }
    public int getLessonPrice() { return this.lessonPrice; }
    public int getLessonTime() { return this.lessonTime; }
    public Rating getRating() {return this.ratings; }
    public int getTotalAttendance() {return this.totalAttendance;}
    public int getEarnings() {return this.earnings;}
    public String[][] getLessonStudents(){ return this.lessonStudents; }
    public String getLessonStudents(int i, int j){ return this.lessonStudents[i][j]; }

}

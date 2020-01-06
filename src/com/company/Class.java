package com.company;

import static com.company.Schedule.classCapacity;
import static com.company.Customer.customerList;

public class Class {
    private String className; // Name of the ETC class.
    private int classTime = 0; // Time of day that the class runs.
    private int classPrice = 20; // cost of attending the class
    private boolean[] classDay = {false, false, false, false, false, false, false, false}; // Timetable of days when class is running
    private int[] classAttendance = {0, 0, 0, 0, 0, 0, 0, 0}; // attendance count for the class on each day
    private Rating ratings; // Ratings object for the class
    private int totalAttendance = 0; // total class attendance on all days combined
    private int earnings = 0; // Earnings from the class = classPrice * totalAttendance
    private String[][] classStudents = new String[8][classCapacity]; // Create array to store the names of students enrolled in class


    // Class constructor
    public Class(String name, int time, int price,  boolean[] day) {
        this.setClassName(name);
        this.setClassTime(time);
        this.setClassPrice(price);
        this.setDay(day);
        this.ratings = new Rating();
    }

    // Class set methods
    public void setClassName(String name)
    {
        this.className = name;
    }
    public void setClassTime(int time)
    {
        this.classTime = time;
    }
    public void setClassPrice(int price)
    {
        this.classPrice = price;
    }
    public void setDay(boolean[] day) { this.classDay = day; }
    public void increaseClassAttendance(int i) { this.classAttendance[i]++; }
    public void decreaseClassAttendance(int i) { this.classAttendance[i]--; }
    public void setTotalAttendance(){this.totalAttendance++; }
    public void decreaseTotalAttendance(){this.totalAttendance--; }
    public void setEarnings(){this.earnings = this.totalAttendance * classPrice; }
    public void setRating(Rating i){ this.ratings = i; }
    public void removeStudent(int i, int j){ this.classStudents[i][j] = "";}
    public void setClassStudents(int i){
        int j;
        if (getClassAttendance(i) < classCapacity) { // Check that the class is not already full
            j = getClassAttendance(i);
            this.classStudents[i][j] = customerList.get(customerList.size() - 1);} // Add the current student's name to the classStudents[][] array
        else { System.out.println("Sorry, class is full.");}
        }

    // Class get methods
    public boolean getClassDay(int i) { return this.classDay[i]; }
    public int getClassAttendance(int i) { return this.classAttendance[i]; }
    public String getClassName() { return className; }
    public int getClassPrice() { return this.classPrice; }
    public int getClassTime() { return this.classTime; }
    public Rating getRating() {return this.ratings; }
    public int getTotalAttendance() {return this.totalAttendance;}
    public int getEarnings() {return this.earnings;}
    public String[][] getClassStudents(){ return this.classStudents; }
    public String getClassStudents(int i, int j){ return this.classStudents[i][j]; }

}

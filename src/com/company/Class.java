package com.company;

import java.util.ArrayList;

public class Class {
    private String className;
    ///private Rating rating;
    private String classTime = "Unspecified";
    private int classPrice = 20;
    private boolean[] classDay = {false, false, false, false, false, false, false, false};
    private int[] classAttendance = {0, 0, 0, 0, 0, 0, 0, 0};
    private Rating ratings;


    public Class(String name, String time, int price,  boolean[] day) {
        this.setClassName(name);
        this.setClassTime(time);
        this.setClassPrice(price);
        this.setDay(day);
        this.ratings = new Rating();

    }

    public Class(){
        this.className = "Unknown";
        this.ratings = new Rating();
    }

    public void setClassName(String name)
    {
        this.className = name;
    }
    public void setClassTime(String time)
    {
        this.classTime = time;
    }
    public void setClassPrice(int price)
    {
        this.classPrice = price;
    }
    public void setDay(boolean[] day) { this.classDay = day; }
    public void increaseClassAttendance(int i) { this.classAttendance[i]++; }
    public void setRating(Rating i){ this.ratings = i; }

    public boolean getClassDay(int i) { return this.classDay[i]; }
    public int getClassAttendance(int i) { return this.classAttendance[i]; }
    public String getClassName() {
        return className;
    }
    public int getClassPrice() {
        return this.classPrice;
    }
    public String getClassTime() {
        return this.classTime;
    }
    public Rating getRating() {return this.ratings; }



    //public String toString()
    {
      //  return this.className+" ("+this.rating+")";
    }
}

package com.company;

public class Class {
    private String className;
    ///private Rating rating;
    private int classCapacity = 20;
    private String classTime = "Unspecified";
    private int classPrice = 20;
    private boolean[] classWeekend = {false, false, false, false};
    private boolean[] classDay = {false, false};
    private boolean daySaturday = false;
    private boolean daySunday = false;

    public Class(String name, String time, int price,  boolean[] weekend, boolean[] day, boolean saturday, boolean sunday) {
        this.setClassName(name);
        this.setClassTime(time);
        this.setClassPrice(price);
        this.setWeekend(weekend);
        this.setDay(day);
        this.setSaturday(saturday);
        this.setSunday(sunday);
        ///rating=new Rating();
    }

    public Class(){
        this.className = "Unknown";
        ///this.rating = new Rating();
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
    public void setWeekend(boolean[] weekend)
    {
        this.classWeekend = weekend;
    }
    public void setDay(boolean[] day) { this.classDay = day; }
    public void setSaturday(boolean saturday)
    {
        this.daySaturday = saturday;
    }
    public void setSunday(boolean sunday)
    {
        this.daySunday = sunday;
    }
    ///public void setRating(Rating rate)
    {
       // this.rating = rate;
    }

    public boolean getClassDay(int i) {
        return classDay[i];
    }

    public boolean getClassWeekend(int i) {
        return classWeekend[i];
    }

    public boolean getSaturday() {
        return this.daySaturday;
    }

    public boolean getSunday() {
        return this.daySunday;
    }

    public String getClassName() {
        return className;
    }

    public int getClassPrice() {
        return this.classPrice;
    }

    public int getClassCapacity() {
        return this.classCapacity;
    }

    public String getClassTime() {
        return this.classTime;
    }

    public boolean getClassDay(){
        return this.daySaturday;
    }

    //public Rating getRating()
    {

       /// return this.rating;
    }



    //public String toString()
    {
      //  return this.className+" ("+this.rating+")";
    }
}

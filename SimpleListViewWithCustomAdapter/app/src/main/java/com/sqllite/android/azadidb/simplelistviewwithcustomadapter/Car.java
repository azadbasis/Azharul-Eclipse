package com.sqllite.android.azadidb.simplelistviewwithcustomadapter;

/**
 * Created by azadidb on 3/15/2016.
 */
public class Car {
    private String make;
    private int year;
    private int iconID;
    private String condition;

    public Car(String make, int year, int iconID, String condition) {
        this.make = make;
        this.year = year;
        this.condition = condition;
        this.iconID = iconID;
    }

    public String getMake() {
        return make;
    }


    public int getYear() {
        return year;
    }


    public int getIconID() {
        return iconID;
    }


    public String getCondition() {
        return condition;
    }

}

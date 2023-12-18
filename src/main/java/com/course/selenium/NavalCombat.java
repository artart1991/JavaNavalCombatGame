package com.course.selenium;

import java.util.ArrayList;

public class NavalCombat {

    private ArrayList<String> locationCells;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public String name;

    public void setName(String n) {
        name = n;
    }

    public String checkYourSelf(String userInput) {

        String result = "Missed";

        int index = locationCells.indexOf(userInput);

        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "Destroyed";
                System.out.println("You sank "+name);
            } else {
                result = "Hit the target";
            }
        }
        return result;
    }
}

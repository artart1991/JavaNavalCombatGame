package com.course.selenium;

import java.util.ArrayList;

public class NavalCombatBust {
    public static void main(String[] args) {
        NavalCombatBust navalGame = new NavalCombatBust();
        navalGame.setUpGame();
        navalGame.startPlaying();
    }

    private GameHelper helper = new GameHelper();
    private ArrayList<NavalCombat> navalCombatList = new ArrayList<NavalCombat>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        NavalCombat first = new NavalCombat();
        first.setName("Aircraft carrier");
        NavalCombat second = new NavalCombat();
        second.setName("Submarine");
        NavalCombat third = new NavalCombat();
        third.setName("Navy Ship");
        navalCombatList.add(first);
        navalCombatList.add(second);
        navalCombatList.add(third);
        System.out.println("Your goal is to sink three sea vessels");
        System.out.println("Aircraft carrier, Submarine, Navy Ship");
        System.out.println("Try to do it using the minimum number of moves");

        for (NavalCombat navalCombatToSet : navalCombatList) {
            ArrayList<String> newLocation = helper.placeNaval(3);
            navalCombatToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!navalCombatList.isEmpty()) {
            String userGuess = helper.getUserInput("Make your choice ");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "Missed";
        for (NavalCombat navalCombatTest : navalCombatList) {
            result = navalCombatTest.checkYourSelf(userGuess);
            if (result.equals("Hit the target")) {
                break;
            }
            if (result.equals("Destroyed")) {
                navalCombatList.remove(navalCombatTest);
                break;
            }
        }
        System.out.println(result);
    }

    public void finishGame() {
        System.out.println("All naval vessels sunk. Congratulations!");
        if (numOfGuesses < 18) {
            System.out.println("You only needed " + numOfGuesses + " tries.");
            System.out.println("Not a bad result for a rookie");
        } else {
            System.out.println("That took you long enough. " + numOfGuesses + " tries.");
            System.out.println("Try harder next time ");
        }
    }

}


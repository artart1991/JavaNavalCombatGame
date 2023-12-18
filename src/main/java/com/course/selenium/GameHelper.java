package com.course.selenium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {

    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int navalCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }

    public ArrayList<String> placeNaval(int navalSize) {
        ArrayList<String> alphaCells = new ArrayList<>();
        String[] alphacoords = new String[navalSize];
        String temp = null;
        int[] coords = new int[navalSize];
        int attempts = 0;
        boolean success = false;
        int location = 0;

        navalCount++;
        int incr = 1;
        if ((navalCount % 2) == 1) {
            incr = gridLength;
        }

        while (!success & attempts++ < 200) {
            location = (int) (Math.random() * gridSize);
            System.out.println("Try "+location);
            int x = 0;

            success = true;
            while (success && x < navalSize) {
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incr;
                    if (location >= gridSize) {
                        success = false;
                    }
                    if (x > 0 && (location % gridLength == 0)) {
                        success = false;
                    } else {
                        System.out.println("used "+location);
                        success = false;
                    }
                }
            }


        }
        int x = 0;
        int row = 0;
        int column = 0;

        while (x < navalSize) {
            grid[coords[x]] = 1;
            row = (int) (coords[x] / gridLength);
            column = coords[x] % gridLength;
            temp = String.valueOf(alphabet.charAt(column));
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            System.out.println(" coord "+x+"="+alphaCells.get(x-1));
        }
        System.out.println("\n");
        return alphaCells;
    }
}

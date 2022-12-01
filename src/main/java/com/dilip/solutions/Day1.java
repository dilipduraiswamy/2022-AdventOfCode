package com.dilip.solutions;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.dilip.util.FileUtil.getFileData;
import static com.dilip.util.FileUtil.getFileFromResource;

public class Day1 {
    public static void main(String[] args) throws URISyntaxException {
        String fileName = "day1/input.txt";
        File file = getFileFromResource(fileName);
        List<String> caloriesData = getFileData(file);
        ArrayList<Integer> totalCalories = getTotalCalories(caloriesData);
        int topMostUtilizedCalories = getTopMostCalories(totalCalories);
        int topThreeMaxCalories = getTopThreeMaxCalories(totalCalories);
        System.out.println("PART A Answer "+topMostUtilizedCalories);
        System.out.println("PART B Answer "+topThreeMaxCalories);
    }

    private static ArrayList<Integer> getTotalCalories(List<String> caloriesData) {
        ArrayList<Integer> totalCalories = new ArrayList<>();
        int temp = 0;
        for (String data : caloriesData) {
            if (!data.trim().isEmpty()) {
                temp = temp + Integer.parseInt(data);
            } else {
                totalCalories.add(temp);
                temp = 0;
            }
        }
        Collections.sort(totalCalories);
        return totalCalories;
    }

    private static int getTopMostCalories(ArrayList<Integer> numbers) {
        return Collections.max(numbers);
    }

    private static int getTopThreeMaxCalories(ArrayList<Integer> numbers) {
        int topThreeMaxCalories = 0;
        if (!numbers.isEmpty()) {
            topThreeMaxCalories = numbers.get(numbers.size() - 1) + numbers.get(numbers.size() - 2) + numbers.get(numbers.size() - 3);
        }
        return topThreeMaxCalories;
    }

}

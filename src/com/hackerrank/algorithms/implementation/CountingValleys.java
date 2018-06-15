package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;

public class CountingValleys implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int numberOfSteps = Integer.parseInt(t.getLineByIndex(0));
        String steps = t.getLineByIndex(1);

        return new FileContent(Integer.toString(countingValleys(numberOfSteps, steps)));
    }

    private static int countingValleys(int n, String s) {
        String[] steps = s.split("");
        int stepCounter = 0;
        int valleyCounter = 0;

        for (String step : steps) {
            if (step.equals("U")) {
                stepCounter++;
                if (stepCounter == 0) valleyCounter++;
            }
            else stepCounter--;
        }

        return valleyCounter;
    }
}

package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;

public class GradingStudents implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int numTestCases = Integer.parseInt(t.getLineByIndex(0));
        int[] grades = new int[numTestCases];

        for (int i = 1; i <= numTestCases; i++) {
            grades[i - 1] = Integer.parseInt(t.getLineByIndex(0));
        }

        int[] roundedGrades = gradingStudents(grades);
        FileContent result = new FileContent();

        for(int i = 0; i < numTestCases; i++) {
            result.addLine(Integer.toString(roundedGrades[i]));
        }

        return result;
    }

    static int[] gradingStudents(int[] grades) {
        int[] roundedScores = new int[grades.length];

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= 38 && grades[i] % 5 > 2) roundedScores[i] = ((grades[i] / 5) + 1) * 5;
            else    roundedScores[i] = grades[i];
        }

        return roundedScores;
    }
}

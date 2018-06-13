package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;

public class BirthdayChocolate implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int n = Integer.parseInt(t.getLineByIndex(0));
        int[] s = new int[n];

        String[] lineSplit = t.getLineByIndex(1).split("\\s+");
        for (int i = 0; i < n; i++) s[i] = Integer.parseInt(lineSplit[i]);

        int d = Integer.parseInt(t.getLineByIndex(2).split("\\s+")[0]);
        int m = Integer.parseInt(t.getLineByIndex(2).split("\\s+")[1]);

        return new FileContent(Integer.toString(solveChocolate(s, d, m)));
    }

    private static int solveChocolate(int[] s, int d, int m) {
        if (m > s.length) return 0;

        int windowSum = 0;
        for (int i = 0; i < m; i++) windowSum += s[i];

        if (m == s.length) {
            if (windowSum == d) return 1;
            return 0;
        }

        int possibilityCount = 0;

        if (windowSum == d) possibilityCount = 1;

        for (int i = m; i < s.length; i++) {
            windowSum += s[i] - s[i - m];

            if (windowSum == d) possibilityCount++;
        }

        return possibilityCount;
    }
}



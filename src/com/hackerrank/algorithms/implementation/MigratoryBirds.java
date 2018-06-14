package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;

public class MigratoryBirds implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int n = Integer.parseInt(t.getLineByIndex(0));
        int[] ar = new int[n];
        String[] lineSplit = t.getLineByIndex(1).split("\\s+");

        for (int i = 0; i < n; i++) ar[i] = Integer.parseInt(lineSplit[i]);

        return new FileContent(Integer.toString(migratoryBirds(ar)));
    }

    private static int migratoryBirds(int[] ar) {
        int[] counts = {0, 0, 0, 0, 0};
        for (int i = 0; i < ar.length; i++) counts[ar[i] - 1]++;

        int maxVal = counts[0];
        int maxIndex = 0;

        for (int i = 1; i < 5; i++) {
            if (counts[i] > maxVal) {
                maxVal = counts[i];
                maxIndex = i;
            }
        }

        return maxIndex + 1;
    }
}

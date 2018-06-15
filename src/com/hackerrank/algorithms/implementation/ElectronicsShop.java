package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

public class ElectronicsShop implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int[] line1 = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(0));
        int budget = line1[0];
        int numKeyboards = line1[1];
        int numDrives = line1[2];

        int[] keyboards = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(1));
        int[] drives = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(2));

        return new FileContent(Integer.toString(getMoneySpent(keyboards, drives, budget)));
    }


    private static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int maxMoneySpent = -1;

        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                if (keyboards[i] + drives[j] <= b &&
                        keyboards[i] + drives[j] > maxMoneySpent) {
                    maxMoneySpent = keyboards[i] + drives[j];
                }
            }
        }

        return maxMoneySpent;
    }
}

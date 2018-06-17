package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

import java.util.Arrays;

public class TheHurdleRace implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        String line1 = t.getLineByIndex(0);
        int n = Integer.parseInt(line1.split("\\s+")[0]);
        int k = Integer.parseInt(line1.split("\\s+")[1]);
        int[] height = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(1));

        return new FileContent(Integer.toString(hurdleRace(k, height)));
    }

    private static int hurdleRace(int k, int[] height) {
        int max = Arrays.stream(height).max().getAsInt();

        if (k > max) return 0;
        else return max - k;
    }
}

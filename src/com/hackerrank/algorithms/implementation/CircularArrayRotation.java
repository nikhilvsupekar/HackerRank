package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

import java.util.Arrays;

public class CircularArrayRotation implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int[] line1Split = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(0));
        int numElements = line1Split[0];
        int rotationCount = line1Split[1];
        int numQueries = line1Split[2];
        int[] numbers = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(1));
        int[] queries = new int[numQueries];

        for (int i = 0; i < numQueries; i++) {
            queries[i] = Integer.parseInt(t.getLineByIndex(i + 2));
        }

        int[] queryResults = circularArrayRotation(numbers, rotationCount, queries);

        FileContent ret = new FileContent();
        for (int i = 0; i < numQueries; i++) {
            ret.addLine(Integer.toString(queryResults[i]));
        }

        return ret;
    }

    private static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int n = a.length;
        return Arrays.stream(queries).map(i -> a[(i + n - (k % n)) % n]).toArray();
    }
}

package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

import java.util.Arrays;

public class AngryProfessor implements Solution {

    @Override
    public FileContent solve(FileContent t) {
        int threshold = Integer.parseInt(t.getLineByIndex(0).split("\\s+")[1]);
        int[] arrivalTimes = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(1));

        return new FileContent(angryProfessor(threshold, arrivalTimes));
    }

    private static String angryProfessor(int k, int[] a) {
        return Arrays.stream(a).filter(t -> t <= 0).count() < k ? "YES" : "NO";
    }
}

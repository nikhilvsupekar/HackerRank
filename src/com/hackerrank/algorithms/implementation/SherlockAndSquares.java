package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

public class SherlockAndSquares implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int[] input = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(0));
        return new FileContent(
                Integer.toString(
                        squares(input[0], input[1])
                )
        );
    }

    private static int squares(int a, int b) {
        int numSquares = (int)(Math.floor(Math.sqrt(b)) - Math.floor(Math.sqrt(a)));
        if (isSquare(a)) numSquares++;
        return numSquares;
    }

    private static boolean isSquare(int n) {
        double sqrt = Math.sqrt(n);
        return Math.floor(sqrt) == Math.ceil(sqrt);
    }
}

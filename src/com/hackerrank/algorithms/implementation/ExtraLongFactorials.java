package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;

import java.math.BigInteger;

public class ExtraLongFactorials implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        return new FileContent(extraLongFactorials(Integer.parseInt(t.getLineByIndex(0))));
    }

    private static String extraLongFactorials(int n) {
        BigInteger factorial = new BigInteger("1");

        for (int i = 1; i <= n; i++)
            factorial = factorial.multiply(new BigInteger(Integer.toString(i)));

        return factorial.toString();
    }
}

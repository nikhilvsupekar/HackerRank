package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;

public class UtopianTree implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int numTestCases = Integer.parseInt(t.getLineByIndex(0));
        FileContent ret = new FileContent();

        for (int i = 1; i <= numTestCases; i++) {
            int n = Integer.parseInt(t.getLineByIndex(i));
            ret.addLine(Integer.toString(utopianTree(n)));
        }

        return ret;
    }

    private static int utopianTree(int n) {
        int f_2k = (int)Math.pow(2, Math.ceil(n * 1.0/2) + 1) - 1;
        return (n % 2 == 0) ? f_2k : f_2k - 1;
    }
}


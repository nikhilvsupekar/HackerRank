package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

import java.util.Arrays;

public class SequenceEquation implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int n = Integer.parseInt(t.getLineByIndex(0));
        int[] p = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(1));
        FileContent ret = new FileContent();

        for (int i : permutationEquation(p)) {
            ret.addLine(Integer.toString(i));
        }

        return ret;
    }

    private static int[] permutationEquation(int[] p) {
        int[] p2 = new int[p.length];

        for (int i = 0; i < p.length; i++) {
            p2[p[p[p[i] - 1] - 1] - 1] = p[i];
        }

        return p2;
    }
}

package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;

public class DrawingBook implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        return new FileContent(
                Integer.toString(
                        pageCount(
                                Integer.parseInt(t.getLineByIndex(0)),
                                Integer.parseInt(t.getLineByIndex(1))
                        )
                )
        );
    }

    private static int pageCount(int n, int p) {
        return (int)Math.min((double)Math.floor(p / 2),
                n % 2 == 0 ? (double)Math.floor((n + 1 - p) / 2):
                        (double)Math.floor((n - p) / 2));
    }

}

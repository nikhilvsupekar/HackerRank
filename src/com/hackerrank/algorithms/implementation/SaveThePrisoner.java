package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

public class SaveThePrisoner implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        String[] lineSplit = t.getLineByIndex(0).split("\\s+");
        return new FileContent(
                Integer.toString(
                        saveThePrisoner(
                                Integer.parseInt(lineSplit[0]),
                                Integer.parseInt(lineSplit[1]),
                                Integer.parseInt(lineSplit[2])
                        )
                )
        );
    }

    private static int saveThePrisoner(int n, int m, int s) {
        return (m + s - 1) % n == 0 ? n : (m + s - 1) % n;
    }
}

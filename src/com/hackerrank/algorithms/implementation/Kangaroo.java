package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;

public class Kangaroo implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        String inputLine = t.getContent().get(0);
        String[] lineSplit = inputLine.split("\\s+");
        int x1 = Integer.parseInt(lineSplit[0]);
        int v1 = Integer.parseInt(lineSplit[1]);
        int x2 = Integer.parseInt(lineSplit[2]);
        int v2 = Integer.parseInt(lineSplit[3]);

        String retLine = kangaroo(x1, v1, x2, v2);

        return new FileContent(retLine);
    }

    private static String kangaroo(int x1, int v1, int x2, int v2) {
        if (v1 == v2 && x1 == x2) return "YES";
        if (v1 == v2 && x1 != x2) return "NO";

        if ((x2 - x1) % (v1 - v2) == 0 && ((x2 - x1) / (v1 - v2) > 0)) return  "YES";
        return "NO";
    }
}

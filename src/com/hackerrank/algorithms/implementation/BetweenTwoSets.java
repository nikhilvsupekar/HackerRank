package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;

public class BetweenTwoSets implements Solution {

    @Override
    public FileContent solve(FileContent t) {
        int aLength = Integer.parseInt(t.getLineByIndex(0).split("\\s+")[0]);
        int bLength = Integer.parseInt(t.getLineByIndex(0).split("\\s+")[1]);

        int[] a = new int[aLength];
        int[] b = new int[bLength];

        String[] lineSplit = t.getLineByIndex(1).split("\\s+");
        for (int i = 0; i < aLength; i++) a[i] = Integer.parseInt(lineSplit[i]);

        lineSplit = t.getLineByIndex(2).split("\\s+");
        for (int i = 0; i < bLength; i++) b[i] = Integer.parseInt(lineSplit[i]);

        int ret = getTotalX(a, b);

        return new FileContent(Integer.toString(ret));
    }

    private static long gcd(long a, long b) {
        if (a > b) {
            if (a % b == 0) return b;
            return gcd(b, a % b);
        } else {
            if (b % a == 0) return a;
            return gcd(a, b % a);
        }
    }

    private static long gcd(int[] a, int n) {
        if (n == 1) return a[0];
        return gcd(a[n-1], gcd(a, n - 1));
    }

    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private static long lcm(int[] a, int n) {
        if (n == 1) return a[0];
        return lcm(a[n-1], lcm(a, n - 1));
    }

    private static int getTotalX(int[] a, int[] b) {
        long x = lcm(a, a.length);
        long y = gcd(b, b.length);

        if (y % x != 0)
            return 0;

        int retCount = 0;

        for (int i = 1; x * i <= y; i++) {
            if (y % (x * i) == 0) retCount++;
        }

        return retCount;
    }
}

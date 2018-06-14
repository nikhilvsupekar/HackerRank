package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;

public class DayOfTheProgrammer implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int year = Integer.parseInt(t.getLineByIndex(0));
        return new FileContent(solve(year));
    }

    private static boolean isGregorianLeap(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    private static boolean isJulianLeap(int year) {
        return year % 4 == 0;
    }

    private static String solve(int year) {
        String dayOfTheProgrammer = "." + Integer.toString(year);

        if (year == 1918)
            dayOfTheProgrammer = "26.09" + dayOfTheProgrammer;
        else if ((year > 1918 && isGregorianLeap(year)) || (year < 1918 && isJulianLeap(year)))
            dayOfTheProgrammer = "12.09" + dayOfTheProgrammer;
        else
            dayOfTheProgrammer = "13.09" + dayOfTheProgrammer;

        return dayOfTheProgrammer;
    }
}

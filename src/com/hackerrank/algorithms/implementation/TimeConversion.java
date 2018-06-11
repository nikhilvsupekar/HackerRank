package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;

public class TimeConversion implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        FileContent result = new FileContent();
        result.addLine(timeConversion(t.getContent().get(0)));
        return result;
    }

    private String timeConversion(String s) {
        String hh = s.split("\\:")[0];

        if (s.endsWith("AM") && hh.equals("12")) hh = "00";
        if (s.endsWith("PM") && !hh.equals("12")) hh = String.valueOf(Integer.parseInt(hh) + 12);

        return (String.valueOf(hh) + s.substring(2, s.length() - 2));
    }
}

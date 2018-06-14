package com.utils;

public class StringUtils {
    public static int[] getArrayOfIntsFromString (String s) {
        String[] lineSplit = s.split("\\s+");
        int[] array = new int[lineSplit.length];

        for(int i = 0; i < lineSplit.length; i++) array[i] = Integer.parseInt(lineSplit[i]);

        return array;
    }
}

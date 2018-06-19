package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CutTheSticks implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int numSticks = Integer.parseInt(t.getLineByIndex(0));
        int[] sticks = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(1));

        return new FileContent(cutTheSticks(sticks));
    }

    private static int[] cutTheSticks(int[] sticks) {
        List<Integer> ret_list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < sticks.length; i++) {
            if (!map.containsKey(sticks[i])) {
                map.put(sticks[i], 1);
            } else {
                map.put(sticks[i], map.get(sticks[i]) + 1);
            }
        }

        int count = 0;
        ret_list.add(sticks.length);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if (count == sticks.length)
                break;

            ret_list.add(sticks.length - count);
        }

        int j = 0;
        int[] ret = new int[ret_list.size()];
        for (Integer r : ret_list) {
            ret[j] = r;
            j++;
        }

        return ret;
    }
}

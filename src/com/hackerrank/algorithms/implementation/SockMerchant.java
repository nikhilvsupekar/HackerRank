package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class SockMerchant implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        return new FileContent(
                    Integer.toString(
                            sockMerchant(
                                    Integer.parseInt(t.getLineByIndex(0)),
                                    StringUtils.getArrayOfIntsFromString(t.getLineByIndex(1))
                            )
                    )
        );
    }

    private static int sockMerchant(int n, int[] ar) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (!set.contains(ar[i]))
                set.add(new Integer(ar[i]));
            else
                set.remove(new Integer(ar[i]));
        }

        return (n - set.size()) / 2;
    }
}

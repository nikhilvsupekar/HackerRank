package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

import java.util.Arrays;

public class PickingNumbers implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int n = Integer.parseInt(t.getLineByIndex(0));
        int[] a = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(1));

        return new FileContent(Integer.toString(pickingNumbers(a)));
    }


    private static int pickingNumbers(int[] a) {
        Arrays.sort(a);

        int localSize = 1;
        int maxSize = -1;
        boolean diffFlag = false;

        for (int i = 1; i < a.length; i++) {
            if (!diffFlag) {
                if (Math.abs(a[i] - a[i - 1]) <= 1) {
                    if (Math.abs(a[i] - a[i - 1]) == 1) {
                        diffFlag = true;
                    }

                    localSize++;
                    if (localSize > maxSize) {
                        maxSize = localSize;
                    }

                } else {
                    localSize = 1;
                    diffFlag = false;
                }

            } else {
                if (Math.abs(a[i] - a[i - 1]) == 0) {
                    localSize++;
                    if (localSize > maxSize) {
                        maxSize = localSize;
                    }

                } else {
                    localSize = 1;
                    diffFlag = false;
                }
            }

        }

        return maxSize;
    }
}

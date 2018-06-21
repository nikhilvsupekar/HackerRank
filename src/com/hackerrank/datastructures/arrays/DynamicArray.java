package com.hackerrank.datastructures.arrays;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

public class DynamicArray implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int[] line1Split = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(0));
        int numSequences = line1Split[0];
        int numQueries = line1Split[1];
        int[][] queries = new int[numQueries][3];

        for (int i = 0; i < numQueries; i++) {
            queries[i] = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(i + 1));
        }

        return new FileContent(dynamicArray(numSequences, queries));
    }

    static int[] dynamicArray(int n, int[][] queries) {
        int[][] seqList = new int[n][];
        int[] seqPointers = new int[n];
        int[] seqThresholds = new int[n];
        int[] ret = new int[queries.length];
        int retCounter = 0;

//        for (int i = 0; i < n; i++) ret[i] = -1;
        for (int i = 0; i < n; i++) seqThresholds[i] = 100;

        int lastAnswer = 0;

        for (int i = 0; i < queries.length; i++) {
            int queryType = queries[i][0];
            int x = queries[i][1];
            int y = queries[i][2];

            int seqNum = (x ^ lastAnswer) % n;

            if (queryType == 1) {
                // seq is empty
                if (seqList[seqNum] == null || seqPointers[seqNum] == 0) {
                    seqList[seqNum] = new int[100];
                }

                // seq has reached its threshold
                // expand
                else if (seqPointers[seqNum] == seqThresholds[seqNum]) {
                    int[] temp = new int[seqThresholds[i]];

                    for (int j = 0; j < seqThresholds[seqNum]; j++) temp[j] = seqList[seqNum][j];

                    seqThresholds[seqNum] *= 2;
                    seqList[seqNum] = new int[seqThresholds[seqNum]];

                    for (int j = 0; j < temp.length; j++) seqList[seqNum][j] = temp[j];

                }

                seqList[seqNum][seqPointers[seqNum]] = y;
                seqPointers[seqNum]++;
            } else {
                lastAnswer = seqList[seqNum][y % seqPointers[seqNum]];
                ret[retCounter] = lastAnswer;
                retCounter++;
            }
        }

        int[] ret1 = new int[retCounter];
        for (int i = 0; i < retCounter; i++) ret1[i] = ret[i];

        return ret1;
    }
}

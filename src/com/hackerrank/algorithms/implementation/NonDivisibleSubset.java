package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

import java.util.*;

public class NonDivisibleSubset implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int[] line1ints = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(0));
        int numElements = line1ints[0];
        int k = line1ints[1];
        int[] elements = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(1));
        return new FileContent(Integer.toString(nonDivisibleSubset(k, elements)));
    }

    private static int nonDivisibleSubset(int k, int[] S) {
        int[] modArray = new int[k];

        if (k == 1) {
            return 1;
        }

        for (int i = 0; i < S.length; i++) modArray[S[i] % k]++;

        int maxSize = 0;

//        for (int i = 0; i < k; i++) {
//            for (int j = i + 1; j < k; j++) {
//                if (i + j != k) {
//                    if (modArray[i] + modArray[j] > maxSize) maxSize = modArray[i] + modArray[j];
//                }
//            }
//        }

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            indexMap.put(i, modArray[i]);
        }

        List<Map.Entry<Integer, Integer>> mapList = new ArrayList<>(indexMap.entrySet());

        Collections.sort(mapList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });


        return maxRecur(mapList, k);
    }

    private static int maxRecur(List<Map.Entry<Integer, Integer>> mapList, int n) {
        if (mapList.size() == 0) return 0;

        Map.Entry<Integer, Integer> head = mapList.get(0);
        if (head == null || head.getValue() == 0) return 0;

        mapList.remove(0);
        if ((n % 2 == 0 && head.getKey() == n / 2) || (head.getKey() == 0 && head.getValue() >= 1)) {
            return 1 + maxRecur(mapList, n);
        }


        if (hasKey(mapList, n - head.getKey())) {
            return head.getValue() + maxRecur(mapList, n);
        } else {
            return maxRecur(mapList, n);
        }

//        int sum = 0;
//        for (int i = 0; i < mapList.size(); i++) {
//            if (n % 2 == 0 && mapList.get(i).getKey().equals(n / 2)) {
//                sum += 1;
//            } else if (hasKey(mapList, n - mapList.get(i).getKey()) || mapList.get(i).getKey() == 0) {
//                sum += mapList.get(i).getValue();
//            }
//        }
//
//        return sum;
    }

    private static boolean hasKey(List<Map.Entry<Integer, Integer>> mapList, Integer k) {
        for (Map.Entry<Integer, Integer> mapEntry : mapList) {
            if (mapEntry.getKey().equals(k)) return true;
        }

        return false;
    }
}

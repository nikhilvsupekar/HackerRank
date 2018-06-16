package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

import java.util.*;

public class MagicSquare implements Solution {

    @Override
    public FileContent solve(FileContent t) {
        int[][] s = new int[3][3];

        for (int i = 0; i < 3; ++i) {
            s[i] = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(i));
        }

        return new FileContent(Integer.toString(formingMagicSquare(s)));
    }

    private static boolean isMagicSquare(int[][] s) {
        int n = s.length;
        int sum = n * (n * n + 1)/2;

        int d1 = 0, d2 = 0;
        for (int i = 0; i < n; i++) {
            int tsum1 = 0;
            for (int j = 0; j < n; j++) {
                tsum1 += s[i][j];
            }

            if (tsum1 != sum) return false;

            tsum1 = 0;
            for (int j = 0; j < n; j++) {
                tsum1 += s[j][i];
            }

            if (tsum1 != sum) return false;

            d1 += s[i][i];
            d2 += s[i][n - 1 - i];
        }

        if (d1 != sum || d2 != sum) return false;

        return true;
    }

    private static List<int[][]> getSquaresFromPList(List<Integer> pList) {
        int n =  (pList.size() + 2) / 2;

        List<int[][]> squareList = new ArrayList<>();
        int[] cflags = new int[4];
        cflags[0] = cflags[1] = cflags[2] = cflags[3] = 0;

        for (int i1 = 0; i1 < 2; i1++)
            for (int i2 = 0; i2 < 2; i2++)
                for (int i3 = 0; i3 < 2; i3++)
                    for (int i4 = 0; i4 < 2; i4++) {
                        cflags[0] = i1;
                        cflags[1] = i2;
                        cflags[2] = i3;
                        cflags[3] = i4;
                        squareList.add(getSquareFromCflags(cflags, pList));
                    }

        return squareList;
    }

    private static int[][] getSquareFromCflags(int[] cflags, List<Integer> pList) {
        int[][] s = new int[3][3];

        s[0][0] = cflags[0] == 0 ? pList.get(0) : 10 - pList.get(0);
        s[0][1] = cflags[1] == 0 ? pList.get(1) : 10 - pList.get(1);
        s[0][2] = cflags[2] == 0 ? pList.get(2) : 10 - pList.get(2);
        s[1][2] = cflags[3] == 0 ? pList.get(3) : 10 - pList.get(3);
        s[1][1] = 5;
        s[1][0] = 10 - s[1][2];
        s[2][0] = 10 - s[0][2];
        s[2][1] = 10 - s[0][1];
        s[2][2] = 10 - s[0][0];

        return s;
    }

    private static int formingMagicSquare(int[][] s) {
        int globalCost = 0;
        int minCost = 9999;
        List<int[][]> magicSquares = new ArrayList<>();

//        if (s[1][1] != 5) {
//            globalCost += Math.abs(s[1][1] - 5);
//            s[1][1] = 5;
//        }

        Set<int[][]> squareSet = new HashSet<>();

        for (List<Integer> pList : generatePermutationList(Arrays.asList(1, 2, 3, 4))) {
            for (int[][] square : getSquaresFromPList(pList)) {
                squareSet.add(square);
                if (isMagicSquare(square)) {
                    magicSquares.add(square);
//                    int localCost = calculateEntropy(s, pList);
                    int localCost = calculateEntropy(s, square);
                    if (localCost < minCost) {
                        minCost = localCost;
                    }
                }

            }

        }

        globalCost += minCost;

        return globalCost;
    }

    private static int calculateEntropy(int[][] s1, int[][] s2) {
        int cost = 0;

        for (int i = 0; i < s1.length; i++)
            for (int j = 0; j < s2.length; j++)
                cost += Math.abs(s1[i][j] - s2[i][j]);

        return cost;
    }

    private static int calculateEntropy(int[][] s, List<Integer> pList) {
        return calculatePairEntropy(s[0][0], s[2][2], pList.get(0)) +
                calculatePairEntropy(s[0][1], s[2][1], pList.get(1)) +
                calculatePairEntropy(s[0][2], s[2][0], pList.get(2)) +
                calculatePairEntropy(s[1][0], s[1][2], pList.get(3));
    }

    /**
     * Calculate the cost required to transform (a, b) -> (p, 10 - p)
     *
     * @param a
     * @param b
     * @param p
     * @return
     */
    private static int calculatePairEntropy(int a, int b, int p) {
        return Math.min(
                Math.abs(a - p) + Math.abs(b - 10 + p),
                Math.abs(a - 10 + p) + Math.abs(b - p)
        );
    }

    private static List<List<Integer>> generatePermutationList(List<Integer> list){
        List<List<Integer>> permutationList = new ArrayList<>();
        if (list.size() == 1) {
            permutationList.add(list);
            return permutationList;
        }

        for (int i = 0; i < list.size(); i++) {
            Integer current = list.get(i);
            List<Integer> temp = new ArrayList<>(list);
            temp.remove(i);
            for (List<Integer> subList : generatePermutationList(temp)) {
                List<Integer> temp1 = new ArrayList<>(subList);
                temp1.add(0, current);

                permutationList.add(temp1);
            }
        }

        return permutationList;
    }
}

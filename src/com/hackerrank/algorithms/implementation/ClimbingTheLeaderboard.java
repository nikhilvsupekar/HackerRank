package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

public class ClimbingTheLeaderboard implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int numLeaderboards = Integer.parseInt(t.getLineByIndex(0));
        int[] leaderboard = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(1));
        int numScores = Integer.parseInt(t.getLineByIndex(2));
        int[] scores = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(3));

        int[] ranking = climbingLeaderboard(leaderboard, scores);

        FileContent ret = new FileContent();
        for(int rank : ranking) {
            ret.addLine(Integer.toString(rank));
        }

        return ret;
    }

    private static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int rankTracker = 1;
        int[] alicesRanks = new int[alice.length];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] != scores[i - 1]) rankTracker++;
        }

        int lPointer = scores.length - 1;
        for (int i = 0; i < alice.length; i++) {
            while (lPointer > 0 && scores[lPointer] < alice[i]) {
                if (scores[lPointer] != scores[lPointer - 1])   rankTracker--;

                lPointer--;
            }

            if (lPointer == 0 && alice[i] >= scores[0]) alicesRanks[i] = 1;
            else    alicesRanks[i] = rankTracker + (alice[i] < scores[lPointer] ? 1 : 0);
        }

        return alicesRanks;
    }
}

package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;

public class ViralAdvertising implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        return new FileContent(
                Integer.toString(
                        viralAdvertising(
                                Integer.parseInt(t.getLineByIndex(0))
                        )
                )
        );
    }

    private static int viralAdvertising(int n) {
        int cLiked = 0;
        int sharedWith = 5;

        for (int i = 0 ; i < n; i++) {
            int liked = (int)Math.floor(sharedWith / 2);
            sharedWith = liked * 3;
            cLiked += liked;
        }

        return cLiked;
    }
}

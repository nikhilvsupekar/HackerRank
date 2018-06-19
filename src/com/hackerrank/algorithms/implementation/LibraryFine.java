package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

public class LibraryFine implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int[] return_date = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(0));
        int[] expected_date = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(1));

        return new FileContent(
                Integer.toString(
                        libraryFine(
                                return_date[0],
                                return_date[1],
                                return_date[2],
                                expected_date[0],
                                expected_date[1],
                                expected_date[2]
                        )
                )
        );
    }


    private static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        return
                (y1 > y2) ? 10000 :
                    (y1 < y2) ? 0 :
                        (m1 > m2) ? (m1 - m2) * 500 :
                            (m1 < m2) ? 0 :
                                (d1 > d2) ? (d1 - d2) * 15 :
                                    0;
    }
}

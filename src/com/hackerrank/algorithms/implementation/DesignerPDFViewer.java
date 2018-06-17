package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;
import com.utils.StringUtils;

public class DesignerPDFViewer implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        int[] height = StringUtils.getArrayOfIntsFromString(t.getLineByIndex(0));
        String word = t.getLineByIndex(1);

        return new FileContent(Integer.toString(designerPdfViewer(height, word)));
    }

    private static int designerPdfViewer(int[] h, String word) {
        int maxHeight = -1;

        for (char c : word.toCharArray()) {
            int hIndex = (int)c - 97;
            if (h[hIndex] > maxHeight) maxHeight = h[hIndex];
        }

        return maxHeight * word.length();
    }
}

package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;

public class AppendAndDelete implements Solution {
    @Override
    public FileContent solve(FileContent f) {
        String s = f.getLineByIndex(0);
        String t = f.getLineByIndex(1);
        int numOperations = Integer.parseInt(f.getLineByIndex(2));
        return new FileContent(appendAndDelete(s, t, numOperations));
    }

    private static String appendAndDelete(String s, String t, int k) {
        char[] s_array = s.toCharArray();
        char[] t_array = t.toCharArray();

        int l1 = s_array.length;
        int l2 = t_array.length;

        if ( (l1 + l2) <= k ) return "Yes";

        int lastMatchingIndex = -1;
        for (int i = 0; i < l1 && i < l2; i++) {
            if (s_array[i] == t_array[i]) {
                lastMatchingIndex = i;
            } else break;
        }

        if (lastMatchingIndex == -1) {
            if (l1 + l2 - 2 * (lastMatchingIndex + 1) <= k) return "Yes";
            return "No";
        }

        int diff = l1 + l2 - 2 * (lastMatchingIndex + 1);
        if (diff == k || (diff <= k && (k - diff) % 2 == 0))
            return "Yes";

        return "No";
    }
}

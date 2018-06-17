package com.hackerrank.algorithms.implementation;

import com.utils.FileContent;
import com.utils.Solution;

import java.util.stream.IntStream;

public class BeautifulDaysAtTheMovies implements Solution {
    @Override
    public FileContent solve(FileContent t) {
        String[] inputSplit = t.getLineByIndex(0).split("\\s+");
        int low = Integer.parseInt(inputSplit[0]);
        int high = Integer.parseInt(inputSplit[1]);
        int k = Integer.parseInt(inputSplit[2]);

        return new FileContent(Integer.toString(beautifulDays(low, high, k)));
    }

    private static int beautifulDays(int i, int j, int k) {
        return (int)IntStream.range(i, j).filter(n -> Math.abs(n - reverseInt(n)) % k == 0).count();
    }

    private static int reverseInt(int n) {
        int reverse = 0;
        int power = (int)Math.floor(Math.log10(n));

        while (n > 0) {
            reverse += (n % 10) * (int)Math.pow(10, power);
            n /= 10;
            power -= 1;
        }

        return reverse;
    }
}

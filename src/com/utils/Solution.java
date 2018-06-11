package com.utils;

import java.util.ArrayList;
import java.util.List;

public interface Solution {

    default public void run(String className) {
        String classDir = className.substring(4).replaceAll("\\.", "/");
        String inputDir = "inputs/" + classDir;
        String resultsDir = "results/" + classDir;
        List<TestCase> testCases = TestCaseReader.readDirectory(inputDir);

        List<Result> results = new ArrayList<>();
        for (TestCase testCase : testCases) {
            results.add(solve(testCase));
        }

        ResultWriter.writeDirectory(results, resultsDir);
    }

    Result solve(TestCase t);
}

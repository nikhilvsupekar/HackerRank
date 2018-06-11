package com.utils;

import java.util.ArrayList;
import java.util.List;

public interface Solution {

    default public void run() {
        String className = this.getClass().getName();
        String classDir = className.substring(4).replaceAll("\\.", "/");
        String inputDir = "data/inputs/" + classDir;
        String outputDir = "data/outputs/" + classDir;
        String resultDir = "data/results/" + classDir;
        List<FileContent> testCases = FileContentIO.readDirectory(inputDir);
        List<FileContent> outputs = FileContentIO.readDirectory(outputDir);
        List<FileContent> results = new ArrayList<>();
        List<Integer> failedTestCaseIndices = new ArrayList<>();

        for (FileContent testCase : testCases) {
            FileContent result = solve(testCase);
            results.add(result);
        }

        FileContentIO.writeDirectory(results, resultDir);

        for (int i = 0; i < testCases.size(); i++) {
            if (!results.get(i).equals(outputs.get(i))) {
                failedTestCaseIndices.add(i + 1);
            }
        }

        System.out.println("Failed test cases: " + failedTestCaseIndices);
    }

    FileContent solve(FileContent t);
}

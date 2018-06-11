package com.utils;

import java.util.ArrayList;
import java.util.List;

public interface Solution {

    default public void run(String className) {
        String classDir = className.substring(4).replaceAll("\\.", "/");
        String inputDir = "inputs/" + classDir;
        String resultsDir = "results/" + classDir;
        List<FileContent> testCases = FileContentIO.readDirectory(inputDir);

        List<FileContent> results = new ArrayList<>();
        for (FileContent testCase : testCases) {
            FileContent result = solve(testCase);
            results.add(result);
        }

        FileContentIO.writeDirectory(results, resultsDir);


    }

    FileContent solve(FileContent t);
}

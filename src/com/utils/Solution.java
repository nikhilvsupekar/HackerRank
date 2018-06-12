package com.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A general interface representing a Solution.
 * Problems to solutions are implemented as objects of classes that implement the solution interface.
 * The default run() takes care of most boiler plate code.
 * The concrete solution to a problem must implement the solve method.
 *
 *
 * @author  Nikhil Supekar
 */
public interface Solution {

    /**
     * Takes care of most of the boiler plate code that needs to be written by a solution provider.
     * This includes reading
     *      test cases from data/inputs/... directory
     *      expected outputs from data/outputs/... directory
     *      writing test results to data/results/... directory
     * All these directories are determined at run time based on the name of the class calling this method.
     * The method calls solve() on all test cases one-by-one and returns a list of ids of the failed test cases.
     *
     * @return List of Integers representing ids of failed test cases
     */
    default List<Integer> run() {
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

//        System.out.println("Failed test cases: " + failedTestCaseIndices);

        return failedTestCaseIndices;
    }

    /**
     * This method triggers the execution of the solution.
     * For best practices, the call to this method should be diverted to another method which does the actual computation.
     * This ensures a smooth migration of the calling function to-and-fro the website.
     * The input is a list of strings (list of lines) representing a typical test case.
     * The interpretation of the input is problem-specific and needs to be parsed in the implementation.
     *
     * @param t     list of strings representing list of input lines as the test case
     * @return      The output in the form of list of strings which is wrapped by FileContent class.
     */
    FileContent solve(FileContent t);
}

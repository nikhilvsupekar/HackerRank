package com.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestCaseReader {

    private static final Logger logger = Logger.getLogger(TestCaseReader.class.getName());

    public static TestCase readFile(String filePath) {
        BufferedReader br = null;
        TestCase testCase = new TestCase();

        if (!new File(filePath).exists()) {
            logger.log(Level.SEVERE, "File " + filePath + " does not exist");
            return null;
        }

        try {
            br = new BufferedReader(new FileReader(filePath));

            String line = "";

            while ((line = br.readLine()) != null) {
                testCase.addLine(line);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return testCase;
    }


    public static List<TestCase> readDirectory(String directoryPath) {
        List<TestCase> testCases = new ArrayList<>();
        File dir = new File(directoryPath);

        // check if directory exists
        if (!(dir.exists() && dir.isDirectory()) || dir.listFiles() == null) {
            logger.log(Level.SEVERE, "Directory " + directoryPath + " does not exist");
            return null;
        }

        for (int i = 1; i <= dir.listFiles().length; i++) {
            testCases.add(readFile(directoryPath + "/" + "test_" + Integer.toString(i) + ".txt"));
        }

        return testCases;
    }
}

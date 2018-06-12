package com.utils;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Abstract class defining the assertion to perform for all solutions.
 * run() returns a list of failed test cases which is compared against an empty list.
 * Tests for concrete solution classes must inherit this class and invoke testRun via the super construct.
 *
 * @author  Nikhil Supekar
 */
public abstract class SolutionTest {

    /**
     * Checks if the list of failed test cases is empty.
     *
     * @param solution  an instance of the concrete solution class
     */
    public void testRun(Solution solution) {
        assertEquals(new ArrayList<>(), solution.run());
    }

}
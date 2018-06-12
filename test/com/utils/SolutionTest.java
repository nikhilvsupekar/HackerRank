package com.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public abstract class SolutionTest {

    public void testRun(Solution solution) {
        assertEquals(new ArrayList<>(), solution.run());
    }

}
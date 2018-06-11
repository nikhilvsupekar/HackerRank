package com.utils;

import java.util.ArrayList;
import java.util.List;

public class Result {
    List<String> lines;

    public Result() {
        lines = new ArrayList<>();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public List<String> getContent() {
        return lines;
    }
}

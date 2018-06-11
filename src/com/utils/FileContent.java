package com.utils;

import java.util.ArrayList;
import java.util.List;

public class FileContent {
    List<String> lines;

    public FileContent() {
        lines = new ArrayList<>();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public List<String> getContent() {
        return lines;
    }
}

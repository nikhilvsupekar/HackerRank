package com.utils;

import java.util.ArrayList;
import java.util.List;

public class FileContent {
    private List<String> lines;

    public FileContent() {
        lines = new ArrayList<>();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public List<String> getContent() {
        return lines;
    }

    public boolean equals(FileContent fc) {
        return this.lines.equals(fc.getContent());
    }
}

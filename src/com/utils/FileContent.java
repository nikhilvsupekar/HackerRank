package com.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class wrapping a list of strings as contents of a file.
 * Contents represent lines in a file.
 *
 * @author  Nikhil Supekar
 */
public class FileContent {
    /**
     * Underlying list of strings storing list of lines of the file
     */
    private List<String> lines;

    public FileContent() {
        lines = new ArrayList<>();
    }

    public FileContent(String line) {
        lines = new ArrayList<>();
        lines.add(line);
    }

    public 
    
    public void addLine(String line) {
        lines.add(line);
    }

    public List<String> getContent() {
        return lines;
    }

    public String getLineByIndex(int i) {
        return lines.get(i);
    }

    public boolean equals(FileContent fc) {
        return this.lines.equals(fc.getContent());
    }
}

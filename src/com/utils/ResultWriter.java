package com.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class ResultWriter {
    private static final Logger logger = Logger.getLogger(ResultWriter.class.getName());

    public static void writeFile(Result result, String filePath) {
        Path path = Paths.get(filePath);

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (String line : result.getContent()) {
                bw.write(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // create directory if it doesn't exist
    // clean up if it exists
    private static void dirInit(String dirPath) throws IOException {
        File dir = new File(dirPath);

        if (dir.exists()) {
            Files.walk(Paths.get(dirPath))
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } else {
            dir.mkdir();
        }
    }

    public static void writeDirectory(List<Result> results, String dirPath) {
        try {
            dirInit(dirPath);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        for (int i = 0; i < results.size(); i++) {
            String filePath = dirPath + "/" + "result_" + Integer.toString(i + 1) + ".txt";
            File file = new File(filePath);
            try {
                file.createNewFile();

                writeFile(results.get(i), filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

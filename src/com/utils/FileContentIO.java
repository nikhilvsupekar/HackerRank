package com.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FileContentIO {

    private static final Logger logger = Logger.getLogger(FileContentIO.class.getName());

    public static FileContent readFile(String filePath) {
        BufferedReader br = null;
        FileContent fileContent = new FileContent();

        if (!new File(filePath).exists()) {
            logger.log(Level.SEVERE, "File " + filePath + " does not exist");
            return null;
        }

        try {
            br = new BufferedReader(new FileReader(filePath));

            String line = "";

            while ((line = br.readLine()) != null) {
                fileContent.addLine(line);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent;
    }

    public static List<FileContent> readDirectory(String directoryPath) {
        List<FileContent> fileContents = new ArrayList<>();
        File dir = new File(directoryPath);

        // check if directory exists
        if (!(dir.exists() && dir.isDirectory()) || dir.listFiles() == null) {
            logger.log(Level.SEVERE, "Directory " + directoryPath + " does not exist");
            return null;
        }

        List<String> fileNames = Arrays.stream(dir.listFiles())
                                        .map(file -> file.getName())
                                        .sorted()
                                        .collect(Collectors.toList());

        for (String fileName : fileNames) {
            fileContents.add(readFile(directoryPath + "/" + fileName));
        }

        return fileContents;
    }


    public static void writeFile(FileContent fileContent, String filePath) {
        Path path = Paths.get(filePath);

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (String line : fileContent.getContent()) {
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
        }

        dir.mkdir();
    }

    public static void writeDirectory(List<FileContent> fileContents, String dirPath) {
        try {
            dirInit(dirPath);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        for (int i = 0; i < fileContents.size(); i++) {
            String filePath = dirPath + "/" + "result_" + Integer.toString(i + 1) + ".txt";
            File file = new File(filePath);
            try {
                file.createNewFile();

                writeFile(fileContents.get(i), filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

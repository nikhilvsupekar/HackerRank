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


/**
 * A class wrapping boiler-plate IO operations on reading/writing files/directories.
 *
 * @author  Nikhil Supekar
 */
public class FileContentIO {

    private static final Logger logger = Logger.getLogger(FileContentIO.class.getName());


    /**
     * Given a file path, return the contents of the file in a FileContent representation.
     *
     * @param filePath  String representing path to a file
     * @return          FileContent object representing contents of the file
     */
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


    /**
     * Given a directory, read all files into a list of FileContent objects.
     * Files are read in the ascending sorted order of their file names.
     * The directory to read files from must exist.
     *
     * @param directoryPath     path to the directory to be read
     * @return                  List of FileContent objects representing contents of all files read in a sorted order
     */
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


    /**
     * Given file content, write it to a given file path
     *
     * @param fileContent   contents of the file to be written
     * @param filePath      path of the file
     */
    public static void writeFile(FileContent fileContent, String filePath) {
        Path path = Paths.get(filePath);

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (String line : fileContent.getContent()) {
                bw.write(line + "\n");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // create directory if it doesn't exist
    // clean up if it exists

    /**
     * Given path to a directory, check if it exists.
     * Cleans up if it is not empty.
     * Creates it if it doesn't exist.
     *
     * @param dirPath       path to the directory
     * @throws IOException
     */
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

    /**
     * Given list of file contents, write them to files in a given directory.
     * The generated files are created with names 'result_i'; 1 <= i <= size(fileContents)
     *
     * @param fileContents  List of file contents to be written to a directory
     * @param dirPath       path of the directory
     */
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

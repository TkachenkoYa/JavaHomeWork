package com.hl.hw25.main.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private FileLoggerConfiguration fileLoggerConfiguration;
    private BufferedWriter writer;
    private FileWriter fileWriter;

    public FileLogger(FileLoggerConfiguration fileLoggerConfiguration) {
        this.fileLoggerConfiguration = fileLoggerConfiguration;
    }

    public void debug(String message) throws IOException {
        File file = new File(FileLoggerConfiguration.getPath());
        checkFileSize(FileLoggerConfiguration.getPath(), message);
        if (FileLoggerConfiguration.getLevel().getLevelValue() >= LoggingLevel.DEBUG.getLevelValue()) {
            message = FileLoggerConfiguration.getFormat()
                    .replace("time", LocalDateTime.now()
                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH_mm"))
                            .replace("level", LoggingLevel.INFO.getLevelTitle())
                            .replace("message", message));
            writer = new BufferedWriter(fileWriter);
            writeToFile(message, file);
        }
    }

    public void info(String message) throws IOException {
        File file = new File(FileLoggerConfiguration.getPath());
        checkFileSize(file.getName(), message);
        if (FileLoggerConfiguration.getLevel().getLevelValue() >= LoggingLevel.INFO.getLevelValue()) {
            message = FileLoggerConfiguration.getFormat()
                    .replace("time", LocalDateTime.now()
                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH_mm"))
                            .replace("level", LoggingLevel.INFO.getLevelTitle())
                            .replace("message", message));
            writer = new BufferedWriter(fileWriter);
            writeToFile(message, file);
        }
    }

    public void writeToFile(String message, File file) {
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(message);
            fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkFileSize(String fileName, String massage) throws IOException {
        byte bytes = 0;
        Path path = Paths.get(fileName);
        try {
            bytes = (byte) (Files.size(path) + massage.getBytes().length);
            if (bytes > FileLoggerConfiguration.getMaxSize()) {

                File newFile = new File(String.format("./Log_%s.txt", LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyy_MM_dd"))));
                newFile.createNewFile();
                throw new FileMaxSizeReachedException("Max size: %s,current size: %s,file path: %s",
                        FileLoggerConfiguration.getMaxSize(), bytes, path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//        if (fileLoggerConfiguration.getPath().length() >= fileLoggerConfiguration.getMaxSize()) {
//            File newFile = new File(String.format("./Log_%s.txt", LocalDateTime.now()
//                    .format(DateTimeFormatter.ofPattern("yyyy_MM_dd HH-mm-ss.SSS"))));
//            fileLoggerConfiguration.setPath(newFile.getPath());
//            fileWriter = new FileWriter(newFile);
//            throw new FileMaxSizeReachedException("Over max file size: " + fileLoggerConfiguration.getMaxSize() +
//                    ", current size: " + fileLoggerConfiguration.getPath().length() + ", file path: " + fileLoggerConfiguration.getPath());
//        }
    }


}
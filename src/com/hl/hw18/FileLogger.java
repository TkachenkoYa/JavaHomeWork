package com.hl.hw18;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private FileLoggerConfiguration fileLoggerConfiguration;
    private BufferedWriter writer;
    private FileWriter fileWriter;

    public FileLogger(FileLoggerConfiguration fileLoggerConfiguration) throws IOException {
        fileWriter = new FileWriter(fileLoggerConfiguration.getFile());
    }

    public void debug(String message) throws IOException {
        checkFileSize();
        if (checkLevel(fileLoggerConfiguration.getLevel())) {
            writer = new BufferedWriter(fileWriter);
            writeToFile(String.format(fileLoggerConfiguration.getFormat(), LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), LoggingLevel.DEBUG, message));
        }
    }

    public void info(String message) throws IOException {
        checkFileSize();
        if (checkLevel(fileLoggerConfiguration.getLevel())) {
            writer = new BufferedWriter(fileWriter);
            writeToFile(String.format(fileLoggerConfiguration.getFormat(), LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), LoggingLevel.INFO, message));
        }
    }

    public void writeToFile(String message) throws IOException {
        writer.write(message);
        writer.newLine();
        writer.flush();
    }

    private void checkFileSize() throws IOException {
        if (fileLoggerConfiguration.getFile().length() >= fileLoggerConfiguration.getMaxSize()) {
            File newFile = new File(String.format("./Log_%s.txt", LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy_MM_dd HH-mm-ss.SSS"))));
            fileLoggerConfiguration.setFile(newFile);
            fileWriter = new FileWriter(newFile);
            throw new FileMaxSizeReachedException("Over max file size: " + fileLoggerConfiguration.getMaxSize() +
                    ", current size: " + fileLoggerConfiguration.getFile().length() + ", file path: " + fileLoggerConfiguration.getFile());
        }
    }

    private boolean checkLevel(LoggingLevel loggingLevel) {
       // if (LoggingLevel.)
            return true;

    }
}
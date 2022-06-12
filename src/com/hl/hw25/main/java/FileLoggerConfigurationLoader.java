package com.hl.hw25.main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {
    public static FileLoggerConfiguration load(String fileName) {
        File file = new File(fileName);
        if (file.exists() && file.length() > 0) {
            FileLoggerConfiguration configuration = new FileLoggerConfiguration();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                bufferedReader.lines().forEach(line -> messageLine(line, configuration));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return configuration;
        }
        return null;
    }

    protected static void messageLine(String line, FileLoggerConfiguration configuration) {
        if (line.startsWith("FILE:")) {
            configuration.setPath(line.split(":")[1].trim());
        } else if (line.startsWith("LEVEL:")) {
            configuration.setLevel(LoggingLevel.valueOf(line.split(":")[1].trim()));
        } else if (line.startsWith("MAX-SIZE:")) {
            configuration.setMaxSize(Byte.parseByte(line.split(":")[1].trim()));
        } else if (line.startsWith("FORMAT:")) {
            configuration.setFormat(line.split("AT:")[1].trim());
        }
    }
}

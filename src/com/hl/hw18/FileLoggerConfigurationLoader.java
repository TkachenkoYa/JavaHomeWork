package com.hl.hw18;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {
    public static FileLoggerConfiguration load(File Configuration) throws IOException {
        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Configuration))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(ConfigStructure.FILE.name()))
                    fileLoggerConfiguration.setFile(new File(line.split(": ")[1]));
                if (line.contains(ConfigStructure.MAX_SIZE.name()))
                    fileLoggerConfiguration.setMaxSize(Byte.valueOf(line.split(": ")[1]));
                if (line.contains(ConfigStructure.LEVEL.name()))
                    fileLoggerConfiguration.setLevel(LoggingLevel.valueOf(line.split(": ")[1]));
                if (line.contains(ConfigStructure.FORMAT.name()))
                    fileLoggerConfiguration.setFormat(line.split(": ")[1]);
                }
        } catch (IOException e) {
            e.getMessage();
        }
        return fileLoggerConfiguration;
    }
}

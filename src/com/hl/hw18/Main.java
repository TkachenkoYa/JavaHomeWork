package com.hl.hw18;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileLogger fileLogger = new FileLogger(FileLoggerConfigurationLoader.load(new File("./Config.txt")));
        fileLogger.info("info massage");
        fileLogger.debug("debug alarm");
    }
}

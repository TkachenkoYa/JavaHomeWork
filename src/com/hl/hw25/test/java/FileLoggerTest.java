package com.hl.hw25.test.java;

import com.hl.hw25.main.java.FileLogger;
import com.hl.hw25.main.java.FileLoggerConfiguration;
import com.hl.hw25.main.java.FileMaxSizeReachedException;
import com.hl.hw25.main.java.LoggingLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerTest {
    private static final String FILE_PATH = "com/hl/hw25/main/resources/Config.txt";
    private FileLogger fileLogger;

    @BeforeAll
    public void initialisation() {
        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration();
        fileLoggerConfiguration.setPath(FILE_PATH);
        fileLoggerConfiguration.setLevel(LoggingLevel.INFO);
        fileLoggerConfiguration.setFormat("[%s] [%s] MESSAGE : [%s]");
        fileLoggerConfiguration.setMaxSize((byte) 90);

        fileLogger = new FileLogger(fileLoggerConfiguration);
    }

    @Test
    public void shouldReturnMassageWhenLoggingLevelInfo()throws IOException {
        fileLogger.info("Info test message");
        FileReader fileReader = new FileReader(FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        Assertions.assertTrue(line.contains("Info test message"));
    }
    @Test
    public void shouldReturnMassageThrowFileMaxSizeReachedException()throws IOException {
        Assertions.assertThrows(FileMaxSizeReachedException.class,()->{
                    fileLogger.info("Info test message for throw File max size reached Exception");
                    fileLogger.info("Info test message for throw File max size reached Exception");
                    fileLogger.info("Info test message for throw File max size reached Exception");
                }
        );
    }
}

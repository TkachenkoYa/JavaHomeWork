package com.hl.hw25.test.java;

import com.hl.hw25.main.java.FileLoggerConfiguration;
import com.hl.hw25.main.java.FileLoggerConfigurationLoader;
import com.hl.hw25.main.java.LoggingLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConfigurationLoaderTest {
    @Test
    public void testFileConfigurationLoader() {
        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration fileLoggerConfiguration = loader
                .load("com/hl/hw25/main/resources/Config.txt");

        Assertions.assertEquals("/path/to/log/file", fileLoggerConfiguration.getPath());
        Assertions.assertEquals(LoggingLevel.DEBUG, fileLoggerConfiguration.getLevel());
        Assertions.assertEquals(250L, fileLoggerConfiguration.getMaxSize());
        Assertions.assertEquals("[%s] [%s] MESSAGE : [%s]", fileLoggerConfiguration.getFormat());
    }
}

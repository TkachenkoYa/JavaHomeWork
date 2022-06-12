package com.hl.hw25.main.java;

public class FileLoggerConfiguration {
    private static String path = "src/com/hl/hw25/main/resources/Config.txt";
    private static LoggingLevel level=LoggingLevel.DEBUG;
    private static byte maxSize=120;
    private static String format="[time][level] Message:[message]";

    public static String getPath() {
        return path;
    }

    public void setPath(String path) {
        FileLoggerConfiguration.path = path;
    }

    public static LoggingLevel getLevel() {
        return level;
    }

    public void setLevel(LoggingLevel level) {
        FileLoggerConfiguration.level = level;
    }

    public static byte getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(byte maxSize) {
        FileLoggerConfiguration.maxSize = maxSize;
    }

    public static String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        FileLoggerConfiguration.format = format;
    }

    @Override
    public String toString() {
        return "FILE: " + path +
                "\n" + "LEVEL: " + level +
                "\n" + "MAX-SIZE: " + maxSize +
                "\n" + "FORMAT: " + format;
    }
}

package com.hl.hw18;

import java.io.File;

public class FileLoggerConfiguration {
    private File log;
    private LoggingLevel level;
    private byte maxSize=120;
    private String format="[%s][%s] Message:[%s]";

    public File getLog() {
        return log;
    }

    public void setLog(File log) {
        this.log = log;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public void setLevel(LoggingLevel level) {
        this.level = level;
    }

    public Byte getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Byte maxSize) {
        this.maxSize = maxSize;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "FILE: " + log +
                "\n" + "LEVEL: " + level +
                "\n" + "MAX-SIZE: " + maxSize +
                "\n" + "FORMAT: " + format;
    }
}

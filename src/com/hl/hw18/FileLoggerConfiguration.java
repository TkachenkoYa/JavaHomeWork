package com.hl.hw18;

import java.io.File;

public class FileLoggerConfiguration {
    private File file;
    private LoggingLevel level;
    private byte maxSize=120;
    private String format="[%s][%s] Message:[%s]";

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
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
        return "FILE: " + file +
                "\n" + "LEVEL: " + level +
                "\n" + "MAX-SIZE: " + maxSize +
                "\n" + "FORMAT: " + format;
    }
}

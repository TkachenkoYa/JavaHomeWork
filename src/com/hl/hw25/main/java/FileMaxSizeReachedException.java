package com.hl.hw25.main.java;

import java.io.IOException;
import java.nio.file.Path;

public class FileMaxSizeReachedException extends IOException {
    private byte maxSize;
    private byte currentSize;
    private Path fileName;

    public FileMaxSizeReachedException(String message, byte maxSize, byte currentSize, Path fileName) {
        super(message);
        this.maxSize = maxSize;
        this.currentSize = currentSize;
        this.fileName = fileName;
    }

    @Override
    public String getMessage(){
        return super.getMessage()+ String.format("Max size: %s,current size: %s,file path: %s", maxSize,currentSize,fileName);
    }
}

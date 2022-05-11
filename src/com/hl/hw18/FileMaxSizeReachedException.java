package com.hl.hw18;

import java.io.File;
import java.io.IOException;

public class FileMaxSizeReachedException extends IOException {
    private Byte maxSize;
    private Byte currentSize;
    private File log;
    public FileMaxSizeReachedException(String message) {
        super(message);
    }
    @Override
    public String getMessage(){
        return super.getMessage()+ String.format("Max size: %s,current size: %s,file path: %s", maxSize,currentSize,log);
    }
}

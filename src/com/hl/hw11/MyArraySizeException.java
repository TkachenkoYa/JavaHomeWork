package com.hl.hw11;

public class MyArraySizeException extends RuntimeException {
    private final int length;

    public MyArraySizeException(String str, int length) {
        super(str);
        this.length = length;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " array size = " + length;
    }
}

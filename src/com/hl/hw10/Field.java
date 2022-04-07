package com.hl.hw10;

public class Field {
    public static final char EMPTY_SYMBOL = '-';
    public static final char X_SYMBOL = 'x';
    public static final char O_SYMBOL = 'o';

    private final char[][] data = {
            {EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL},
            {EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL},
            {EMPTY_SYMBOL, EMPTY_SYMBOL, EMPTY_SYMBOL}
    };

    public char[][] getData() {
        return data;
    }

    public void setValue(int h, int v, char ch) {
        data[h][v] = ch;
    }
}

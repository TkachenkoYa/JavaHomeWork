package com.hl.hw10;

import static com.hl.hw10.Field.EMPTY_SYMBOL;

public class DrawChecker {
    public boolean draw(Field field) {
        char[][] data = field.getData();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (data[i][j] == EMPTY_SYMBOL) {
                    return false;
                }
            }
        }
        return true;
    }
}
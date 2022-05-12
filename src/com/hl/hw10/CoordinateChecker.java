package com.hl.hw10;

import static com.hl.hw10.Field.*;

public class CoordinateChecker {

    public boolean isCellEmpty(Field field, Coordinate coordinate) {
        char[][] data = field.getData();
        return data[coordinate.getH() - 1][coordinate.getV() - 1] == EMPTY_SYMBOL;
    }
}

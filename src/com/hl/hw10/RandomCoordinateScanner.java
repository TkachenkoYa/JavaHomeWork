package com.hl.hw10;

public class RandomCoordinateScanner implements CoordinateScanner {
    @Override
    public Coordinate scan() {
        return new Coordinate((int) (1 + Math.random() * 3), (int) (1 + Math.random() * 3));
    }
}

package com.hl.hw7;

public class Quadrate extends Figure implements GeometricFigure {
    private double side;

    public Quadrate(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }
}

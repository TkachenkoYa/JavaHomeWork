package com.hl.hw7;

public class Triangle extends Figure implements GeometricFigure {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double area() {
        return (base * height) / 2;
    }
}
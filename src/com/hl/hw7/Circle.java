package com.hl.hw7;

public class Circle extends Figure implements GeometricFigure{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * (radius * radius);
    }
}

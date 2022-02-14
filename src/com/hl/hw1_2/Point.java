package com.hl.hw1_2;

public class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static double distance(Point point, Circle circle) {

        return (Math.sqrt(Math.pow(Math.abs(point.getX() - circle.getCenter().getX()), 2)
                + Math.pow(Math.abs(point.getY() - circle.getCenter().getY()), 2)));
    }
}

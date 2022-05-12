package com.hl.hw1_2;

public class Circle {
    Point center;
    double R;

    public void setR(double r) {
        this.R = r;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public boolean containsPoint(Point point, Circle circle) {
        return Point.distance(point, circle) < R;
    }
}

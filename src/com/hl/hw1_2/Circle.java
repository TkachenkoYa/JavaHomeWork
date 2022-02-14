package com.hl.hw1_2;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Circle)) return false;
        Circle circle = (Circle) obj;
        return Double.compare(circle.R, R) == 0 && Objects.equals(getCenter(), circle.getCenter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCenter(), R);
    }

    public boolean containsPoint(Point point, Circle circle) {
        return Point.distance(point, circle) < R;
    }
}

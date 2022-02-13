package com.hl.hw1_2;

import java.util.ArrayList;
import java.util.Objects;

public class PointList {

    ArrayList<Point> points = new ArrayList();

    public void add(Point point) {
        points.add(point);
    }

    //    public void addX(double x) {
//
//        Point.setX(x);
//    }
//
//    public void addY(double y) {
//        points.add(y);
//    }
//
//
//
    public int size() {
        int size = points.size();
        return size;
    }

    public Point get(int i) {
        return points.get(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PointList)) return false;
        PointList pointList = (PointList) o;
        return Objects.equals(points, pointList.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}

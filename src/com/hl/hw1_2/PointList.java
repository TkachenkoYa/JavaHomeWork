package com.hl.hw1_2;

import java.util.ArrayList;

public class PointList {

    ArrayList<Point> points = new ArrayList();

    public void add(Point point) {
        points.add(point);
    }

    public int size() {
        int size = points.size();
        return size;
    }

    public Point get(int i) {
        return points.get(i);
    }
}

package com.hl.hw1_2;

import java.util.ArrayList;

public class PointList {
    int x;
    int y;
    ArrayList<Integer> points=new ArrayList();

    void addX(int x){
points.add(x);
}
    void addY(int  y){
        points.add(y);
    }
    public void printPointList(){
        System.out.println("Вы ввели такие точки:");
        for (int i=0; i<points.size();i+=2){
           int currentX= points.get(i);
           int currentY= points.get(i+1);
            System.out.println("Точка ("+currentX+"; "+currentY+")");
        }
    }
    public int size(){
        int size= points.size();
        return size;
    }
    public int get(int i){
        return points.get(i);
    }
}

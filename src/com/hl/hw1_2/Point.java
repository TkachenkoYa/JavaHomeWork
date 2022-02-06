package com.hl.hw1_2;

import java.util.Scanner;

public class Point {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PointList pointList = new PointList();
        int choice = 0;
        while (choice != 2) {
            System.out.println("Введите координаты точки");
            System.out.print("х=");
            pointList.addX(in.nextInt());
            System.out.print("y=");
            pointList.addY(in.nextInt());
            System.out.println("Желаете добавить еще? (1-да, 2-нет)");
            choice = in.nextInt();
        }
        System.out.println("Введите координаты центра окружности");
        Circle circle = new Circle();
        System.out.print("х=");
        circle.setCenterX(in.nextInt());
        System.out.print("y=");
        circle.setCenterY(in.nextInt());
        System.out.println("Введите радиус окружности");
        System.out.print("R=");
        circle.setR(in.nextInt());
       // pointList.printPointList();

        for (int i = 0; i < pointList.size(); i += 2) {
            int currentX = pointList.get(i);
            int currentY = pointList.get(i + 1);
            circle.belonging(currentX, currentY);
        }
    }
    public double distance(int x, int y) {
        Circle circle=new Circle();
        double l = Math.sqrt(Math.pow(Math.abs(x - circle.getCenterX()), 2) +
                Math.pow(Math.abs(y - circle.getCenterY()), 2));
        //System.out.println(l);
return l;
    }

}

package com.hl.hw1_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PointList points = new PointList();

        int choice = 0;
        while (choice != 2) {
            Point current = new Point();
            System.out.println("Введите координаты точки");
            System.out.print("х=");
            current.setX(in.nextDouble());
            System.out.print("y=");
            current.setY(in.nextDouble());
            points.add(current);
            System.out.println("Желаете добавить еще? (1-да, 2-нет)");
            choice = in.nextInt();
        }
        System.out.println("Введите координаты центра окружности");
        Circle circle = new Circle();
        Point center = new Point();
        System.out.print("х=");
        center.setX(in.nextDouble());
        System.out.print("y=");
        center.setY(in.nextDouble());
        circle.setCenter(center);
        System.out.println("Введите радиус окружности");
        System.out.print("R=");
        circle.setR(in.nextDouble());

        for (int i = 0; i < points.size(); i++) {

            if (circle.containsPoint(points.get(i), circle)) {
                System.out.printf("[%s, %s]\n", points.get(i).getX(), points.get(i).getY());
            }
        }
    }
}
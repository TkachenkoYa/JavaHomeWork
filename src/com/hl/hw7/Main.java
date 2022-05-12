package com.hl.hw7;

public class Main {
    public static void main(String[] args) {
        Figure[] figures = {new Circle(1.5), new Triangle(5.0, 3.0), new Quadrate(2.0)};
        sumArea(figures);
    }

    public static void sumArea(Figure[] figures) {
        double sum = 0;
        for (int i = 0; i < figures.length; i++) {
            sum += figures[i].area();
        }
        System.out.println(sum);
    }
}

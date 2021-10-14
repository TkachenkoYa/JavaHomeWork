package com.pb.tkachenkoya.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a;
        int b;
        int x;

        System.out.println("Примитивный калькулятор");
        System.out.println("Введите первое целое число и нажмите Enter");
        a = in.nextInt();

        System.out.println("Введите второе целое число и нажмите Enter");
        b = in.nextInt();

        System.out.println("Введите арифметическую операцию: +,-,*,/ и нажмите Enter");
        String sign = in.next();
        switch (sign) {
            case "+":
                x = (a + b);
                System.out.println("Результат сложения " + x);
                break;
            case "-":
                x = (a - b);
                System.out.println("Результат вычитания " + x);
                break;
            case "*":
                x = (a * b);
                System.out.println("Результат умножения " + x);
                break;
            case "/":
                if (b == 0) {
                    System.out.println("На 0 делить нельзя");
                } else {
                    double dx;
                    dx = (double) a / (double) b;
                    System.out.println("Результат деления " + dx);
                }
                break;
            default:
                System.out.println("Не допустимая операция");

        }
    }
}

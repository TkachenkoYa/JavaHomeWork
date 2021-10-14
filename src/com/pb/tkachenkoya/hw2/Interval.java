package com.pb.tkachenkoya.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int y;
        System.out.println("Определение интервала");
        System.out.println("Введите целое число и нажмите Enter");
        y = in.nextInt();
        if (y>=0 && y<=14){
            System.out.println("Введеное число соответствует интервалу [0;14]");}
        else if (y>=15 && y<=35){
            System.out.println("Введеное число соответствует интервалу [15;35]");}
        else if (y>=36 && y<=50){
            System.out.println("Введеное число соответствует интервалу [36;50]");}
        else if (y>=51 && y<=100){
            System.out.println("Введеное число соответствует интервалу [51;100]");}
        else {
            System.out.println("Введеное число не соответствует ни одному интервалу");
        }
    }
}

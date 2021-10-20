package com.pb.tkachenkoya.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {

    public static void main(String[] args) {
        System.out.println("Угадайте задуманное число от 0 до 100");
        System.out.println("Для выхода из программы введите любое число меньше 0 или больше 100");
        int a = 1; // счетчик

                Random random = new Random();
        int x = random.nextInt(101); //генерация числа
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Попытка №" + a);
            a++;
            int y = in.nextInt();
            if (y>x && y<101){
                System.out.println("Ваше число больше загаданного");
            }else if (y<x && y>-1){
                System.out.println("Ваше число меньше загаданного");
            }else if (y>100 || y<0 ){
                System.out.println("Игра окончена((");
                break;
            }
            else {
                System.out.println("Поздавляем, Вы угадали c "+(--a)+" попыток!");
                break;
            }
        }
    }
}

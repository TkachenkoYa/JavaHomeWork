package com.pb.tkachenkoya.hw3;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        int[] array = new int[10];
        Scanner in = new Scanner(System.in);
        System.out.println("Введите 10 целых чисел: ");
        for (int i = 0; i < 10; i++) {
            array[i] = in.nextInt();
        }
        System.out.println("Вы ввели: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println(" ");
        int sum = 0;//Сумма всех элементов
        for (int i = 0; i < 10; i++) {
            sum = sum + array[i];
        }
        System.out.println("Сумма введенных чисел: " + sum);
        int p = 0;//Количество положительных элементов
        for (int i = 0; i < 10; i++) {
            if (array[i] > 0) {
                p++;
            }
        }
        System.out.println("Положительных элементов: " + p);
             int b;//временная переменная для перестановок
                    for (int i = 0; i < 9; i++) {
                        for (int j = 9; j > i; j--) {
                            if (array[j-1] > array[j]) {
                            b = array[j-1];
                            array[j - 1] = array[j];
                            array[j] =  b;
                             }
                        }
                    }
        System.out.println("Сортировка этого массива от меньшего к большему по пузырьковому алгоритму: ");
            for (int i = 0; i < 10; i++) {
            System.out.print(" " + array[i]);
            }
    }
}



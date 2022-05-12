package com.hl.hw3_2;

import java.util.Scanner;

public class Numbers {

    public int[] numbersSquare() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размар массива");
        int size = in.nextInt();
        int[] numbers = new int[size];
        int[] numbersSquare = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = ((int) (Math.random() * 100) - (int) (Math.random() * 100));
            System.out.print(numbers[i] + ", ");
            numbersSquare[i] = (int) Math.pow(numbers[i], 2);
        }
        System.out.println();
        for (int i = 0; i < size; ++i) {
            for (int j = size - 1; j > i; --j) {
                if (numbersSquare[j - 1] > numbersSquare[j]) {
                    int current = numbersSquare[j - 1];
                    numbersSquare[j - 1] = numbersSquare[j];
                    numbersSquare[j] = current;
                }
            }
        }
        System.out.println("Массив квадратов по возрастанию");
        for (int i = 0; i < numbersSquare.length; i++) {
            System.out.print(numbersSquare[i] + ", ");
        }
        return numbersSquare;

    }
}

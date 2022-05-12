package com.hl.hw4;

import java.util.Scanner;

public class SortArrayByParity {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размар массива");
        int size = in.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = ((int) (Math.random() * 20));
            System.out.print(numbers[i] + ", ");
        }
        System.out.println();
        sortArray(numbers);
        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i] + ", ");
        }
    }

    public static int[] sortArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        while (i != j) {
            if (numbers[i] % 2 != 0) {
                int current = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = current;
                --j;
            } else ++i;
        }
        return numbers;
    }
}



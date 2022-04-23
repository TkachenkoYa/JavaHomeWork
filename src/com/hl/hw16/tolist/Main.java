package com.hl.hw16.tolist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"pink", "orange", "blue", "wight", "black", "red"};
        System.out.println("Array of strings: " + Arrays.toString(strings));
        Integer[] numbers = {1, 2, 3, 67, 45, 4, 8, 5};
        System.out.println("Array of numbers: " + Arrays.toString(numbers));
        System.out.println("List of strings: " + toList(strings));
        System.out.println("List of numbers: " + toList(numbers));

    }

    private static <T> List<T> toList(T[] array) {
        List<T> outputList = new ArrayList<T>();
        for (T t : array) {
            outputList.add(t);
        }
        return outputList;
    }
}


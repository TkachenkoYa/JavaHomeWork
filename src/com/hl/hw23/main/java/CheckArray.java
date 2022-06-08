package com.hl.hw23.main.java;

import java.util.Arrays;

public class CheckArray {
    public static int[] arrayAfterFour(int[] array) {
        if (Arrays.stream(array).noneMatch(number -> number == 4)) {
            throw new RuntimeException("There is no 4 in your array");
        }
        int indexLastFour = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4)
               indexLastFour=i;
        }
        int[] arrayAfterLastFour = new int[array.length - indexLastFour - 1];
        int index = 0;
        for (int i = indexLastFour + 1; i < array.length; i++) {
            arrayAfterLastFour[index] = array[i];
            index++;
        }
        return arrayAfterLastFour;
    }

    public static boolean onlyFourAndOne(int[] array) {
        if (Arrays.stream(array).allMatch(x -> x == 1) || Arrays.stream(array).allMatch(x -> x == 4)) {
            return false;
        } else {
            return Arrays.stream(array).allMatch(x -> x == 1 || x == 4);
        }
    }
}


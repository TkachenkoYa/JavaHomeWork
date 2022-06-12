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
                indexLastFour = i;
        }
        int arrayAfterLastFourLength = array.length - indexLastFour + 1;
        int[] arrayAfterLastFour = new int[arrayAfterLastFourLength];
        System.arraycopy(array, indexLastFour + 1, arrayAfterLastFour, 0, arrayAfterLastFourLength);
        return arrayAfterLastFour;
    }

    public static boolean onlyFourAndOne(int[] array) {
        boolean onlyFourAndOne = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1 || array[i] == 4)
                onlyFourAndOne = true;
            else {
                onlyFourAndOne = false;
                break;
            }
        }
        return onlyFourAndOne;
    }
}


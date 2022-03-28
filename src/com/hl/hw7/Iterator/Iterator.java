package com.hl.hw7.Iterator;

import java.util.Arrays;
import java.util.stream.Stream;

public class Iterator {
    private int[][] arr;
    private int row;
    private int col;

    public Iterator(int[][] arr) {
        this.arr = arr;
    }

    public void sort(int[][] arr) {
        int index = 0;
        int count = Stream.of(arr).mapToInt(m -> m.length).sum();
        int[] temp = new int[count];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < (arr[row].length); col++) {
                temp[index] = arr[row][col];
                index++;
            }
        }
        Arrays.sort(temp);
        index = 0;
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < (arr[row].length); col++) {
                arr[row][col] = temp[index];
                index++;
            }
        }
    }

    public boolean hasNext() {
        while (row < arr.length && arr[row].length == col) {
            row++;
            col = 0;
        }
        return row < arr.length;
    }

    public int next() {
        sort(arr);
        if (arr[row].length == 0) {
            while (arr[row].length == 0) {
                row++;
                col = 0;
            }
        }
        int result = arr[row][col++];
        if (col >= arr[row].length) {
            row++;
            col = 0;
        }
        return result;
    }
}



package com.hl.hw3_3;

import java.util.Scanner;

public class Permutation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку");
        String str = in.nextLine();
        StringBuffer strBuf = new StringBuffer(str);
        permutation(strBuf, 0);
    }

    private static void permutation(StringBuffer str, int index) {

        if (index == str.length())
            System.out.print(str + ", ");
        else {
            permutation(str, index + 1);
            for (int i = index + 1; i < str.length(); i++) {
                swap(str, index, i);
                permutation(str, index + 1);
                swap(str, i, index);
            }
        }
    }

    private static void swap(StringBuffer str, int first, int second) {
        char t1 = str.charAt(first);
        str.setCharAt(first, str.charAt(second));
        str.setCharAt(second, t1);
    }

}

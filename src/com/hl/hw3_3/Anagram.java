package com.hl.hw3_3;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первую строку");
        String str1 = in.nextLine();
        System.out.println("Введите вторую строку");
        String str2 = in.nextLine();
        System.out.println(anagram(str1, str2));
    }

    public static boolean anagram(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        char[] arrF1 = str1.replaceAll("(?U)[\\pP\\s]", "").toCharArray();
        Arrays.sort(arrF1);
        char[] arrS2 = str2.replaceAll("(?U)[\\pP\\s]", "").toCharArray();
        Arrays.sort(arrS2);

        if (arrF1.length != arrS2.length) {
            return false;
        } else {
            return Arrays.equals(arrF1, arrS2);
        }
    }
}

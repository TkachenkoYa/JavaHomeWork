package com.pb.tkachenkoya.hw4;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите первую строку");
        String first = in.nextLine();

        System.out.println("Введите вторую строку");
        String second = in.nextLine();

        if (Anagr(first, second)) {
            System.out.println("Введенные строки являются анаграммой");
        }
        else {
            System.out.println("Это не анаграмма");
        }
    }
    private static boolean Anagr(String f1, String s2) {
        f1 = f1.toLowerCase();
        s2 = s2.toLowerCase(); //избавление от больших букв
        char[] arrF1 = f1.replaceAll("(?U)[\\pP\\s]", "").toCharArray();
        Arrays.sort(arrF1);
//убираем пробелы, знаки препинания и сортируем массивы по порядку
        char[] arrS2 = s2.replaceAll("(?U)[\\pP\\s]", "").toCharArray();
        Arrays.sort(arrS2);

        if (arrF1.length != arrS2.length) {  //проверяем одинаковой ли длины массивы
            return false;
        }
        else //проверяем одинаковы ли массивы
        {
            return Arrays.equals(arrF1, arrS2);
        }
    }
        }



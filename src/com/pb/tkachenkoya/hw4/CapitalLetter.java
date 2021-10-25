package com.pb.tkachenkoya.hw4;

import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args) {
        System.out.println("Введите строку прописными буквами");
        Scanner in = new Scanner(System.in);
        String let = in.nextLine();
        String pri=myMetod (let);
        System.out.println(pri);
    }

        public static String myMetod(String string) {
            StringBuilder f = new StringBuilder(string);
            for (int i = 0; i < f.length(); i++)
               if (i == 0 || f.charAt(i - 1) == ' ') // проверка если символ первый, а перед ним пробел,то
                    f.setCharAt(i, Character.toUpperCase(f.charAt(i))); // делаем этот символ заглавным
            return f.toString(); //возвращает в строку
    }
    }

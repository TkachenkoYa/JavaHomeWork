package com.hl.hw12.list1a;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry");

        System.out.println("Count occurance Cherry " + countOccurance(strings, "cherry"));

        Integer[] numbers = new Integer[]{1, 2, 3};
        System.out.println("Было: " + Arrays.toString(numbers));
        System.out.println("Стало " + toList(numbers));

        List<Integer> number = new ArrayList<>();
        Collections.addAll(number, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6, 45, 34, 123, 1, 2, 787);
        System.out.println(Arrays.asList(number));
        System.out.println("Unique numbers: " + findUnique(number));

        calcOccurance(strings);

        System.out.println(findOccurance(strings));
    }

    public static int countOccurance(List<String> strings, String str) {

        return Collections.frequency(strings, str);
    }

    public static List toList(Integer[] numbers) {

        return Arrays.asList(numbers);
    }

    public static List findUnique(List<Integer> number) {
        List<Integer> unique = new ArrayList<>();
        for (int i = 0; i < number.size(); i++) {
            if (Collections.frequency(number, number.get(i)) < 2)
                unique.add(number.get(i));
        }
        return unique;
    }

    public static void calcOccurance(List<String> strings) {
        List<String> stringUnique = findUniqueString(strings);
        for (int i = 0; i < stringUnique.size(); i++) {
            int count = 0;
            for (int j = 0; j < strings.size(); j++) {
                if (stringUnique.get(i).equals(strings.get(j)))
                    count++;
            }
            System.out.println(stringUnique.get(i) + ": " + count);
        }
    }

    public static List findOccurance(List<String> strings) {

        List<String> findOccurance = new ArrayList<>();
        List<String> stringUnique = findUniqueString(strings);
        for (int i = 0; i < stringUnique.size(); i++) {
            int count = 0;
            for (int j = 0; j < strings.size(); j++) {
                if (stringUnique.get(i).equals(strings.get(j)))
                    count++;
            }
            findOccurance.add("{name: \"" + stringUnique.get(i) + "\", occurrence: " + count + "}");
        }
        return findOccurance;
    }

    public static List findUniqueString(List<String> strings) {
        List<String> stringUnique = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            if (!stringUnique.contains(strings.get(i)))
                stringUnique.add(strings.get(i));
            else break;
        }
        return stringUnique;
    }
}

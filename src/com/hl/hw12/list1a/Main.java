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
        List<Integer> list = Arrays.asList(numbers);
        return list;
    }

    public static List findUnique(List<Integer> number) {
        List<Integer> unique = new ArrayList<>();
        for (int i = 0; i < number.size(); i++) {
            if (Collections.frequency(number, number.get(i)) < 2) {
                unique.add(number.get(i));
            }
        }
        return unique;
    }

    public static void calcOccurance(List<String> strings) {
        Map<String, Integer> counter = new HashMap<>();
        for (String string : strings) {
            Integer count = counter.get(string);
            if (count == null) {
                count = 0;
            }
            counter.put(string, ++count);
        }
        for (String string : counter.keySet()) {
            System.out.println(string + ": " + counter.get(string));
        }
    }
    public static List findOccurance(List<String> strings) {
        Map<String, Integer> counter = new HashMap<>();
        for (String string : strings) {
            Integer count = counter.get(string);
            if (count == null) {
                count = 0;
            }
            counter.put(string, ++count);
        }
        List<String> findOccurance=new ArrayList<>();
        for (String string : counter.keySet()) {
            findOccurance.add("{name: \""+string + "\", occurrence: " + counter.get(string)+"}");
        }
        return findOccurance;
    }
}

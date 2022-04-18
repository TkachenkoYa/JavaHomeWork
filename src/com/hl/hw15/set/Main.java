package com.hl.hw15.set;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        Collections.addAll(strings, "zero", "three", "two", "two", "four", ",", "five", "five", "seven", "nine", "nine", "ten");
        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 6, 2, 1, 1, 5, 5, 7, 8, 9, 3);

        System.out.println("Before " + strings);
        System.out.println("After " + convertToUnique(strings));
        System.out.println();
        System.out.println("Before " + numbers);
        System.out.println("After sort " + getSortedUniqueIntegersASC(numbers));
        System.out.println("After reverse sort " + getSortedUniqueIntegersDESC(numbers));
        System.out.println();
        System.out.println("Build sentence direction " + buildSentenceDirection(strings));
    }

    public static Set<String> convertToUnique(ArrayList<String> strings) {
        return new HashSet<String>(strings);
    }

    public static TreeSet<Integer> getSortedUniqueIntegersASC(ArrayList<Integer> numbers) {
        return new TreeSet<Integer>(numbers);
    }

    public static Set<Integer> getSortedUniqueIntegersDESC(ArrayList<Integer> numbers) {
        Collections.sort(numbers, Collections.reverseOrder());
        return new LinkedHashSet<>(numbers);
    }

    public static Set<String> buildSentenceDirection(ArrayList<String> strings) {
        return new LinkedHashSet<>(strings);
    }
}

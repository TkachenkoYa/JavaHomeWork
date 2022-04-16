package com.hl.hw14.task2a;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> linkedStrings = new LinkedList<>();

        Collections.addAll(linkedStrings, "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
        addFirst(linkedStrings, "eleven");

        addLast(linkedStrings, "minus one");

        LinkedList<Integer> param1 = new Random().ints(5, 0, 10).
                collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        System.out.println("param1 " + param1);
        LinkedList<Integer> param2 = new Random().ints(5, 0, 10).
                collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        System.out.println("param2 " + param2);
        System.out.println("result " + join(param1, param2));
        System.out.println();

        System.out.println("before " + linkedStrings);
        System.out.println("after 1 shuffle " + shuffle(linkedStrings));
        System.out.println("after 2 shuffle " + shuffle(linkedStrings));
        System.out.println("after 3 shuffle " + shuffle(linkedStrings));
        System.out.println();

        System.out.println("param1 " + param1);
        System.out.println("param2 " + param2);
        System.out.println("result " + intersect(param1, param2));
        System.out.println();
    }

    public static void addFirst(LinkedList<String> linkedStrings, String str) {
        System.out.println(linkedStrings);
        linkedStrings.addLast(str);
        System.out.println("addFirst " + linkedStrings);
        System.out.println();
    }

    public static void addLast(LinkedList<String> linkedStrings, String str) {
        System.out.println(linkedStrings);
        linkedStrings.addFirst(str);
        System.out.println("addLast " + linkedStrings);
        System.out.println();
    }

    public static LinkedList<Integer> join(LinkedList<Integer> param1, LinkedList<Integer> param2) {
        LinkedList<Integer> join = new LinkedList<>();
        join.addAll(param1);
        join.addAll(param2);
        return join;
    }

    public static LinkedList<String> shuffle(LinkedList<String> linkedStrings) {
        Collections.shuffle(linkedStrings);
        return linkedStrings;
    }

    public static LinkedList<Integer> intersect(LinkedList<Integer> param1, LinkedList<Integer> param2) {
        LinkedList<Integer> intersect = new LinkedList<>();
        for (int i = 0; i < param1.size(); i++) {
            if (param1.contains(param2.get(i)))
                intersect.add(param2.get(i));
        }
        return intersect;
    }
}

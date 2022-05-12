package com.hl.hw17.DoublyLinkedList;

import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> digits = new DoublyLinkedList<Integer>() {
        };
        digits.addFirst(1);
        digits.add(5, 1);
        digits.add(1, 2);
        digits.add(6, 3);
        digits.add(8);
        System.out.println("First: " + digits.get(0));
        System.out.println("Second: " + digits.get(1));
        System.out.println("Third: " + digits.get(2));
        System.out.println("last: " + digits.get(4));

        ListIterator<Integer> iterator = digits.doublyListIteratorForIndex(0);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        iterator.set(10);
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");

        }
    }
}

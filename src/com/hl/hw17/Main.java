package com.hl.hw17;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> digits = new SinglyLinkedList<>();

        digits.add(1);
        digits.add(5);
        System.out.println("First: " + digits.get(0));
        System.out.println("Second: " + digits.get(1));

        digits.add(8);
        System.out.println("Third: " + digits.get(2));

        System.out.println("Size: " + digits.size());
        digits.add(6);
        digits.add(3);
//        digits.remove(digits.size() - 1);
  //      digits.remove(digits.size() / 2);
//        digits.remove(0);
        System.out.println("Size: " + digits.size());

        System.out.println("First: " + digits.get(0));
        System.out.println("Second: " + digits.get(1));

        System.out.println("Third: " + digits.get(3));
        System.out.printf("Size: "+digits.size());
        System.out.println();
        SinglyListIterator<Integer> iterator = digits.singlyListIterator();
        System.out.print(digits.get(0)+" ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
            }

        }
}

package com.hl.hw16.friutBox;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.add(new Apple());
        Box<Orange> orangeBox1 = new Box<>(new Orange());
        orangeBox1.addItem(new Orange(), new Orange(), new Orange());
        Box<Apple> appleBox2 = new Box<>(new Apple(), new Apple(), new Apple(), new Apple());

        System.out.printf("orangeBox1:\t%s\t- %.1f\n\n", orangeBox1, orangeBox1.getWeight());
        System.out.println("Added 1 orange");
        orangeBox1.add(new Orange());
        System.out.printf("orangeBox1:\t%s\t- %.1f\n\n", orangeBox1, orangeBox1.getWeight());

        System.out.printf("appleBox1:\t%s\t- %.1f\n", appleBox1, appleBox1.getWeight());
        System.out.println("Added 2 apples");
        appleBox1.addItem(new Apple(), new Apple());
        System.out.printf("appleBox1:\t%s\t- %.1f\n", appleBox1, appleBox1.getWeight());

        System.out.println("Compare apple box 1 and orange box 1 by weight is " + appleBox1.compare(orangeBox1));

        System.out.println("Merged fruit from apple box 1 into apple box 2");
        appleBox1.merge(appleBox2);
        System.out.printf("appleBox1:\t%s\t- %.1f\n", appleBox1, appleBox1.getWeight());
        System.out.printf("appleBox2:\t%s\t- %.1f\n", appleBox2, appleBox2.getWeight());
    }
}

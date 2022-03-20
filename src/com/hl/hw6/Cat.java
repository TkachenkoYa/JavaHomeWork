package com.hl.hw6;

public class Cat extends Animal {
    private String name;
    private static int count;

    public Cat() {
        count++;
    }

    public Cat(String name) {
        this();
        this.name = name;

    }

    public static int getCount() {
        return count;
    }
    @Override
    public void run(Double distance) {
        if (distance <= 200 && distance > 0) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else System.out.println(name + " - кот, потому "+distance+" м. не пробежит");
    }

    @Override
    public void swim(Double distance) {
        System.out.println(name + " - кот, поэтому не плавает");
    }
}

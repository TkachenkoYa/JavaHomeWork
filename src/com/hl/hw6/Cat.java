package com.hl.hw6;

public class Cat extends Animal {
    private String name;
    private static int count;
    private final Double MAX_DISTANCE = 200.0;

    public Cat(String name) {
        this.name = name;
        count++;
    }

    public static int getCount() {
        return count;
    }
    @Override
    public void run(Double distance) {
        if (distance <= MAX_DISTANCE && distance > 0) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else System.out.println(name + " - кот, потому "+distance+" м. не пробежит");
    }

    @Override
    public void swim(Double distance) {
        System.out.println(name + " - кот, поэтому не плавает");
    }
}

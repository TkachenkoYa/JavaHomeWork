package com.hl.hw6;

public class Dog extends Animal {
    private String name;
    private static int count;
    private final Double MAX_RUN_DISTANCE = 500.0;
    private final Double MAX_SWIM_DISTANCE = 10.0;

    public Dog(String name) {
        this.name = name;
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run(Double distance) {
        if (distance <= MAX_RUN_DISTANCE && distance > 0) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else System.out.println(name + " - собака и " + distance + " м. пробежать не может");
    }

    @Override
    public void swim(Double distance) {
        if (distance <= MAX_SWIM_DISTANCE && distance > 0) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else System.out.println(name + " - собака и " + distance + " м. не проплывет");
    }
}

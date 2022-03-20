package com.hl.hw6;

public class Dog extends Animal {
    private String name;
    static int count;

    public Dog() {
        count++;
    }

    public Dog(String name) {
        this();
        this.name = name;

    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run(Double distance) {
        if (distance <= 500 && distance > 0) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else System.out.println(name + " - собака и "+distance+" м. пробежать не может");
    }

    @Override
    public void swim(Double distance) {
        if (distance <= 10 && distance > 0) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else System.out.println(name + " - собака и "+distance+" м. не проплывет");
    }
}

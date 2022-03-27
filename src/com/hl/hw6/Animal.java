package com.hl.hw6;

public class Animal {
    private String name;
    private static int count;

    public static int getCount() {
        return count;
    }

    public Animal() {
        count++;
    }

    public Animal(String name) {
        this();
        this.name = name;
    }

    public void run(Double distance) {
    }

    public void swim(Double distance) {

    }
}

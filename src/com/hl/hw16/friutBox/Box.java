package com.hl.hw16.friutBox;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private Class<?> boxType;
    private ArrayList<T> box;

    public Box(T... fruits) {
        this.boxType = fruits.getClass().getComponentType();
        this.box = new ArrayList<>(Arrays.asList(fruits));

    }

    public void add(T fruit) {
        box.add(fruit);
    }

    public void addItem(T... fruits) {
        box.addAll(Arrays.asList(fruits));
    }

    public double getWeight() {
        float weight = 0.0f;
        for (Fruit f : box) {
            weight += f.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public int getNum() {
        return this.box.size();
    }

    public void setEmpty() {
        box.clear();
    }

    public void merge(Box<T> anotherBox) {
        if (box == anotherBox.box) {
            System.out.println("This is one box");
            return;
        }
        box.addAll(anotherBox.box);
        anotherBox.setEmpty();
    }

    @Override
    public String toString() {
        return "Box contains " + box.size() + " " + boxType.getSimpleName();
    }
}

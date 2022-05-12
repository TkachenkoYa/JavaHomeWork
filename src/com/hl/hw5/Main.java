package com.hl.hw5;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        SameName sameName = new SameName();
        sameName.name();
        com.hl.hw5.sameName.SameName sameName1 = new com.hl.hw5.sameName.SameName();
        sameName1.name();
    }
}

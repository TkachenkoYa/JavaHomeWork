package com.hl.hw5;

public class Car {
    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
    }

    private void startElectricity() {
        System.out.println("start Electricity");
    }

    private void startCommand() {
        System.out.println("start Command");
    }

    private void startFuelSystem() {
        System.out.println("start Fuel System");
    }

}

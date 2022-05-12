package com.hl.hw8;

public abstract class Participant {
    private String name;
    private double MAX_DISTANCE;
    private double MAX_HIGH;


    public Participant() {
    }

    public double getMAX_DISTANCE() {
        return MAX_DISTANCE;
    }

    public double getMAX_HIGH() {
        return MAX_HIGH;
    }

    public Participant(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void run(Treadmill treadmill);

    public abstract void jump(Wall wall);

}

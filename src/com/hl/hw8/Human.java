package com.hl.hw8;

public class Human extends Participant {
    private String name;
    private final double MAX_DISTANCE = 600.0;
    private final double MAX_HIGH = 3.0;

    public double getMAX_DISTANCE() {
        return MAX_DISTANCE;
    }

    public double getMAX_HIGH() {
        return MAX_HIGH;
    }

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Участник " + name;
    }

    @Override
    public void run(Treadmill treadmill) {
        if (treadmill.getLength() <= getMAX_DISTANCE())
            System.out.println("Человек " + getName() + " пробежал " + treadmill.getLength() + " метров");
        else System.out.println("Человек " + getName() + " не смог пробежать " + treadmill.getLength() + " метров");
    }

    @Override
    public void jump(Wall wall) {
        if (wall.getHigh() <= getMAX_HIGH())
            System.out.println("Человек " + getName() + " смог перепрыгнуть препятствие высотой " + wall.getHigh() + " метра");
        else System.out.println("Человек " + getName() + " не смог перепрыгнуть препятствие");
    }
}

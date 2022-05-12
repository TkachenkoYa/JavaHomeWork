package com.hl.hw8;

public class Robot extends Participant {
    private String name;
    private final double MAX_DISTANCE = 700.0;
    private final double MAX_HIGH = 2.0;

    public double getMAX_DISTANCE() {
        return MAX_DISTANCE;
    }

    public double getMAX_HIGH() {
        return MAX_HIGH;
    }

    @Override
    public String toString() {
        return "Участник " + name;
    }

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run(Treadmill treadmill) {
        if (treadmill.getLength() <= getMAX_DISTANCE())
            System.out.println("Робот " + getName() + " пробежал " + treadmill.getLength() + " метров");
        else System.out.println("Робот " + getName() + " не смог пробежать " + treadmill.getLength() + " метров");
    }

    @Override
    public void jump(Wall wall) {
        if (wall.getHigh() <= getMAX_HIGH())
            System.out.println("Робот " + getName() + " смог перепрыгнуть препятствие высотой " + wall.getHigh() + " метра");
        else System.out.println("Робот " + getName() + " не смог перепрыгнуть препятствие");
    }
}

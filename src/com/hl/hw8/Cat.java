package com.hl.hw8;

public class Cat extends Participant {
    private String name;
    private final double MAX_DISTANCE = 200.0;
    private final double MAX_HIGH = 3.0;

    public Cat(String name) {
        this.name = name;
    }

    public double getMAX_DISTANCE() {
        return MAX_DISTANCE;
    }

    public double getMAX_HIGH() {
        return MAX_HIGH;
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
            System.out.println("Кот " + getName() + " пробежал " + treadmill.getLength() + " метров");
        else System.out.println("Кот " + getName() + " не смог пробежать " + treadmill.getLength() + " метров");
    }

    @Override
    public void jump(Wall wall) {
        if (wall.getHigh() <= getMAX_HIGH())
            System.out.println("Кот " + getName() + " смог перепрыгнуть препятствие высотой " + wall.getHigh() + " метра");
        else System.out.println("Кот " + getName() + " не смог перепрыгнуть препятствие высотой " + wall.getHigh());
    }
}

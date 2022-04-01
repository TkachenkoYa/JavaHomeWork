package com.hl.hw8;

public class Treadmill extends Let {
    private final String name = "беговая дорожка";
    private final double length = 400.0;

    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public boolean overcome(Participant participant) {
        if (getLength() <= participant.getMAX_DISTANCE()) {
            System.out.println("Участник " + participant.getName() + " прошел препятствие "
                    + getName() + " на дистанции " + getLength() + " метров");
            return true;
        } else {
            System.out.println("Участник " + participant.getName() + " не прошел препятствие " + getName() +
                    ". Пройдено " + participant.getMAX_DISTANCE() + " метров");
            System.out.println(participant.getName()+" выбывает из игры");
            return false;
        }
    }
}

package com.hl.hw8;

public class Wall extends Let {
    private final String name = "стена";
    private final double high = 2.5;

    public String getName() {
        return name;
    }

    public double getHigh() {
        return high;
    }

    public boolean overcome(Participant participant) {
        if (getHigh() <= participant.getMAX_HIGH()) {
            System.out.println("Участник " + participant.getName() + " прошел препятствие "
                    + getName() + " на высоте " + getHigh() + " метра");
            return true;
        } else {
            System.out.println("Участник " + participant.getName() + " не прошел препятствие " + getName() +
                    ". Пройдено " + participant.getMAX_HIGH() + " метра");
            System.out.println(participant.getName()+" выбывает из игры");
            return false;
        }
    }
}


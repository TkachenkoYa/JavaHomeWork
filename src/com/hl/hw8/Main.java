package com.hl.hw8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Participant> participants = new ArrayList<Participant>();
        participants.add(new Cat("Барсик"));
        participants.add(new Robot("R2-D2"));
        participants.add(new Human("Вася"));

        List<Let> lets = new ArrayList<Let>();
        lets.add(new Wall());
        lets.add(new Treadmill());

        trial(lets, participants);
    }

    public static void trial(List<Let> lets, List<Participant> participants) {
        for (int i = 0; i < lets.size(); i++) {
            for (int j = 0; j < participants.size(); j++) {
                if (lets.get(i).overcome(participants.get(j)) == false) {
                    participants.remove(j);
                    j--;
                }
            }
        }
    }
}



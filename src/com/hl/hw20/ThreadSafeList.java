package com.hl.hw20;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadSafeList {
    CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

    public synchronized void add(String newWorld) {
        toSleep(1000, 2000);
        arrayList.add(newWorld);
    }

    public synchronized void remove(int index) {
        toSleep(3000, 10000);
        arrayList.remove(index);
    }

    public synchronized List<String> get() {
        toSleep(3000, 10000);
        return this.arrayList;
    }

    public synchronized String get(int index) {
        toSleep(3000, 10000);
        return this.arrayList.get(index);
    }

    public static void toSleep(int a, int b) {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(a, b));
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}

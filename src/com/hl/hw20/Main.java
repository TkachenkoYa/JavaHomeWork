package com.hl.hw20;

public class Main {
    public static void main(String[] args) {
        PetrolStation petrolStation1 = new PetrolStation(1_000);

        new Thread(getRefuelingRunner(petrolStation1, 50)).start();
        new Thread(getRefuelingRunner(petrolStation1, 80)).start();
        new Thread(getRefuelingRunner(petrolStation1, 100)).start();
        new Thread(getRefuelingRunner(petrolStation1, 300)).start();
        new Thread(getRefuelingRunner(petrolStation1, 400)).start();

        ThreadSafeList threadSafeList = new ThreadSafeList();
        new Thread(getThreadSafeListRunner(threadSafeList)).start();
        new Thread(getThreadSafeListRunner(threadSafeList)).start();
        new Thread(getThreadSafeListRunner(threadSafeList)).start();
    }

    public static Runnable getThreadSafeListRunner(ThreadSafeList threadSafeList) {
        return new Runnable() {
            @Override
            public void run() {
                threadSafeList.add("First");
                threadSafeList.add("Second");
                threadSafeList.add("End");
                threadSafeList.remove(1);
            }
        };
    }

    public static Runnable getRefuelingRunner(PetrolStation petrolStation, double amount) {
        return new Runnable() {
            @Override
            public void run() {
                petrolStation.doRefuel(amount);
            }
        };
    }
}

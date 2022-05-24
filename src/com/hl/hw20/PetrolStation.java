package com.hl.hw20;

import java.util.concurrent.Semaphore;

import static com.hl.hw20.ThreadSafeList.toSleep;

public class PetrolStation {
    private final Semaphore semaphore = new Semaphore(3);
    private double amount;

    public PetrolStation(double amount) {
        this.amount = amount;
    }

    public void doRefuel(double amount) {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " refueling started (amount = " + this.amount + ")");
            toSleep(3000, 10000);
            this.amount = this.amount - amount;
            if (this.amount < 0) {
                throw new RuntimeException("Sorry, run out of gas");
            } else {
                System.out.println(Thread.currentThread().getName() + " refueling is over (amount = " + this.amount + ")");
            }
        } catch (InterruptedException e) {
            e.getMessage();
        } finally {
            semaphore.release();
        }
    }
}

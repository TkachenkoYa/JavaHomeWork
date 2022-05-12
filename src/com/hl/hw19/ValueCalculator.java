package com.hl.hw19;

import java.util.Arrays;

public class ValueCalculator {
    private static final int SIZE = 1000000;
    private static final int HALF = SIZE / 2;
    private final float[] array = new float[SIZE];

    public void doCalc() {
        long start = System.currentTimeMillis();
        Arrays.fill(array, 2);

        float[] current1 = new float[HALF];
        float[] current2 = new float[HALF];

        System.arraycopy(array, 0, current1, 0, HALF);
        System.arraycopy(array, HALF, current2, 0, HALF);

        Thread t0 = new Thread(getCalcOperation(current1));
        Thread t1 = new Thread(getCalcOperation(current2));

        t0.start();
        t1.start();

        try {
            t0.join();
            t1.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }

        System.arraycopy(current1, 0, array, 0, HALF);
        System.arraycopy(current2, 0, array, HALF, HALF);

        long end = System.currentTimeMillis() - start;

        System.out.println("Calculation time: " + end);
    }

    private Runnable getCalcOperation(float[] array) {
        return new Runnable() {
            @Override
            public void run() {
                doCalc(array);
            }
        };
    }

    private void doCalc(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}

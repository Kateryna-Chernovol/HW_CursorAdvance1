package com.cursor.advance.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//import static com.cursor.advance.concurrent.H2O.BARRIER;
//import static com.cursor.advance.concurrent.H2O.moleculesCount;

public class Hydrogen implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private int moleculesCount;

    public Hydrogen(CyclicBarrier cyclicBarrier, int moleculesCount) {
        this.cyclicBarrier = cyclicBarrier;
        this.moleculesCount = moleculesCount;
    }

    private void releaseHydrogen() {
        System.out.print("H");

    }

    @Override
    public void run() {
        for (int i = 0; i < moleculesCount; i++) {
            try {
                cyclicBarrier.await();
                releaseHydrogen();
//                Thread.sleep(100);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

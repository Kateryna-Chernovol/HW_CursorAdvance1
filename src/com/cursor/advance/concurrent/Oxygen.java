package com.cursor.advance.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Oxygen implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private int moleculesCount;

    public Oxygen(CyclicBarrier cyclicBarrier, int moleculesCount) {
        this.cyclicBarrier = cyclicBarrier;
        this.moleculesCount = moleculesCount;
    }

    private void releaseOxygen() {
        System.out.print("O");
    }

    @Override
    public void run() {
        for (int i = 0; i < moleculesCount; i++) {
            try {
                cyclicBarrier.await();
                releaseOxygen();
//                Thread.sleep(100);
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

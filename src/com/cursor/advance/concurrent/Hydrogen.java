package com.cursor.advance.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static com.cursor.advance.concurrent.H2O.BARRIER;
import static com.cursor.advance.concurrent.H2O.moleculesCount;

public class Hydrogen implements Runnable {
    CyclicBarrier cyclicBarrier = BARRIER;

    @Override
    public void run() {
        for (int i = 0; i < moleculesCount; i++) {
            try {
                cyclicBarrier.await();
                System.out.print("H");
                if (cyclicBarrier.await() == 0) {
                    System.out.println();
                }
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.cursor.advance.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Hydrogen extends Thread {

    private Semaphore hydrogenBarrier;
    private CyclicBarrier cyclicBarrier;

    public Hydrogen(Semaphore hydrogenBarrier, CyclicBarrier cyclicBarrier) {
        this.hydrogenBarrier = hydrogenBarrier;
        this.cyclicBarrier = cyclicBarrier;
    }

    private void releaseHydrogen() {
        System.out.print("H");
    }

    @Override
    public void run() {
        try {
            hydrogenBarrier.acquire();
            cyclicBarrier.await();
            releaseHydrogen();
            hydrogenBarrier.release();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

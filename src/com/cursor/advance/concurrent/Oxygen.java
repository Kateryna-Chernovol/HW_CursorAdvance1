package com.cursor.advance.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Oxygen extends Thread {
    private final Semaphore oxygenBarrier;
    private final CyclicBarrier cyclicBarrier;

    public Oxygen(Semaphore oxygenBarrier, CyclicBarrier cyclicBarrier) {
        this.oxygenBarrier = oxygenBarrier;
        this.cyclicBarrier = cyclicBarrier;
    }

    private void releaseOxygen() {
        System.out.print("O");
    }

    @Override
    public void run() {
        try {
            oxygenBarrier.acquire();
            cyclicBarrier.await();
            releaseOxygen();
            oxygenBarrier.release();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

package com.cursor.advance.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class WaterCreator {
    private final Semaphore hydrogenBarrier = new Semaphore(2);
    private final Semaphore oxygenBarrier = new Semaphore(1);
    private final CyclicBarrier waterBarrier = new CyclicBarrier(3, System.out::println);

    public void create(String str) {
        char[] input = str.toCharArray();
        for (char element : input) {
            if (element == 'H') {
                new Hydrogen(hydrogenBarrier, waterBarrier).start();
            } else {
                new Oxygen(oxygenBarrier, waterBarrier).start();
            }
        }
    }
}

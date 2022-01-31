package com.cursor.advance.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MoleculeCreating {
    private Semaphore hydrogenBarrier = new Semaphore(2);
    private Semaphore oxygenBarrier = new Semaphore(1);
    private CyclicBarrier waterBarrier = new CyclicBarrier(3, new MoleculeSeparator());

    public void createWater(String str) {
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

package com.cursor.advance.concurrent;

public class MoleculeCreating implements Runnable {

    private void moleculeCreated() {
        System.out.println();
    }

    @Override
    public void run() {
        moleculeCreated();
    }
}

package com.cursor.advance.concurrent;

public class MoleculeSeparator implements Runnable {

    private void moleculeSeparator() {
        System.out.println();
    }

    @Override
    public void run() {
        moleculeSeparator();
    }
}

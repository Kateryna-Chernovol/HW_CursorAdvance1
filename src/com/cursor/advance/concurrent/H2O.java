package com.cursor.advance.concurrent;

import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;

public class H2O {
    public static int moleculesCount;
    static final CyclicBarrier BARRIER = new CyclicBarrier(3);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of H2O molecules: ");
        moleculesCount = input.nextInt();
        new Thread(new Hydrogen()).start();
        new Thread(new Hydrogen()).start();
        new Oxygen().run();
    }
}

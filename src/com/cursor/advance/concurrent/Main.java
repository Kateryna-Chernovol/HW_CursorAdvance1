package com.cursor.advance.concurrent;

import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of H2O molecules: ");
        int moleculesCount = input.nextInt();

        while (moleculesCount > 0 && moleculesCount < 1000) {

            for (int i = 0; i < moleculesCount; i++) {
                System.out.println("H2O molecule # " + (i + 1) + " created");

                new Thread(new Hyrdogen(cyclicBarrier)).start();
                new Thread(new Hyrdogen(cyclicBarrier)).start();
                new Thread(new Oxygen(cyclicBarrier)).start();

                Thread.sleep(500);
                System.out.println();

            }
            moleculesCount = 0;
        }
    }
}

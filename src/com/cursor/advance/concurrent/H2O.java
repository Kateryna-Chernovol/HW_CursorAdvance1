package com.cursor.advance.concurrent;

import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;

public class H2O {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new MoleculeCreating());
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of H2O molecules: ");

        int moleculesCount = input.nextInt();
        new Thread(new Hydrogen(cyclicBarrier, moleculesCount)).start();
        new Thread(new Hydrogen(cyclicBarrier, moleculesCount)).start();
        new Thread(new Oxygen(cyclicBarrier, moleculesCount)).start();

    }
}

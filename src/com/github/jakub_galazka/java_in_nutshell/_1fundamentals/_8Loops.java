package com.github.jakub_galazka.java_in_nutshell._1fundamentals;

public class _8Loops {

    private static void forLoop(int iterations) {
        for (int i = 0; i < iterations; i++) {
            if (i % 2 == 0) {
                continue;   // Skip to next iteration
            }

            System.out.println(i);

            if (i == 101) {
                break;      // Exit loop
            }
        }
    }

    private static void forEachLoop() {
        int[] array = new int[10];

        for (int element : array) {
            System.out.println(element);
        }
    }

    private static void whileLoop(int i) {
        while (i < Integer.MAX_VALUE) {
            System.out.println(i);
            i++;
        }
    }

    private static void doWhileLoop(int i) {
        // At least 1 iteration -> no condition check in first iteration
        do {
            System.out.println(i);
            i++;
        } while (i < Integer.MAX_VALUE);
    }
}

package com.github.jakub_galazka.java_in_nutshell._1fundamentals;

import java.util.Arrays;

public class _10Arrays {

    private static void arrays() {
        int[] array = new int[10]; // Array of default values: int -> 0, boolean -> false, Object -> null
        int[] inlineArrayInitialization = { 0, 1, 2 };

        int arrayLength = array.length; // 10

        // Coping Array -> shallow copy (IF: Array of objects) - coping Array but NOT objects inside it
        int[] arrayCopy = Arrays.copyOf(array, array.length);
    }
}

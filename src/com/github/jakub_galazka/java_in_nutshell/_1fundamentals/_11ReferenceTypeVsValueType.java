package com.github.jakub_galazka.java_in_nutshell._1fundamentals;

public class _11ReferenceTypeVsValueType {

    private static void referenceTypeVsValueType() {
        // Value type - holds a value (primitive types)
        // Reference type - holds reference / address to object but not the object itself (i.e. Array)

        int a = 0;              // a = 0
        int b = a;              // b = 0
        b = 1;                  // a = 0, b = 1

        int[] A = new int[3];   // A -> [0, 0, 0]
        int[] B = A;            // A -> B -> [0, 0, 0]
        B[0] = 1;               // A -> B -> [1, 0, 0]
    }
}

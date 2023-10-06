package com.github.jakub_galazka.java_in_nutshell._1fundamentals;

public class _12Methods {

    // void method / procedure (method returning type: void)
    private static void procedure(int param1, int param2) { // Parameters
        int value = function(param1, param2); // Arguments (actual values)
        System.out.println(value);
    }

    // return method / function
    private static int function(int param1, int param2) {
        if ((param1 < 0) || (param2 < 0)) {
            return -1; // -1 -> indicate an error
        }
        return param1 + param2;
    }

    // Method Overloading - to overload a method, create a method with the same name and other parameters.
    private static int function(int param1) {
        return param1 * param1;
    }
}

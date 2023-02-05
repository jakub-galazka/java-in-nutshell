package com.github.jakub_galazka.java_in_nutshell._1fundamentals;

public class _6IfStatement {

    private static void ifStatement(int number) {
        // GOOD PRACTISE: extra brackets in: if ((...) && (...))
        if ((number >= 0) && (number <= 10)) {
            System.out.println("Given number belongs to [0, 10]");
        } else if ((number >= 11) && (number <= 100)) {
            System.out.println("Given number belongs to [11, 100]");
        } else if ((number >= 101) && (number <= 1000)) {
            System.out.println("Given number belongs to [101, 1000]");
        } else {
            System.out.println("Given number belongs to [minIntValue, -1] or [1001, maxIntValue]");
        }
    }
}

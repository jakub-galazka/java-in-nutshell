package com.github.jakub_galazka.java_in_nutshell._1fundamentals;

public class _7SwitchStatement {

    private static void switchStatement(int number) {
        /*
            switch statement can be used with 4 primitive types: byte, short, int, char
            [since Java 7] String in switch is also available
         */
        switch (number) {
            case 0:
                System.out.println("Given number equals to 0");
                break;
            case 1:
                System.out.println("Given number equals to 1");
                break;
            case 2: case 3: case 4:
                System.out.println("Given number belongs to {2, 3, 4}");
                break;
            default:
                System.out.println("Given number is not supported");
                break; // Last break is no needed
        }

        // ========================================================================================================================================================================================================

        // [since Java 13] Enhanced switch
        switch (number) {
            case 0 -> System.out.println("Given number equals to 0");
            case 1 -> System.out.println("Given number equals to 1");
            case 2, 3, 4 -> System.out.println("Given number belongs to {2, 3, 4}");
            default -> System.out.println("Given number is not supported");
        }
    }
}

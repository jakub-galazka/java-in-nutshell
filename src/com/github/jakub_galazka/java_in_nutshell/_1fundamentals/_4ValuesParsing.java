package com.github.jakub_galazka.java_in_nutshell._1fundamentals;

public class _4ValuesParsing {

    private static void valuesParsing() {
        String stringNumber = "1";
        int intNumber = Integer.parseInt(stringNumber);
        double doubleNumber = Double.parseDouble(stringNumber);
        // String stringNumber = "a"; -> ERROR: NumberFormatException
    }
}

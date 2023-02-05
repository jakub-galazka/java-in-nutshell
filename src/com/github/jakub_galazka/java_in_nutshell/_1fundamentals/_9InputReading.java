package com.github.jakub_galazka.java_in_nutshell._1fundamentals;

import java.util.Locale;
import java.util.Scanner;

public class _9InputReading {

    private static void inputReading() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);           // Use . separator for floating points numbers

        System.out.println("Enter value:");
        while (!scanner.hasNextDouble()) {      // Without this condition -> ERROR: InputMismatchException (IF INPUT: String)
            System.out.println("Invalid value");
            scanner.nextLine();
        }
        double value = scanner.nextDouble();    // Read line to break character (\n)
        scanner.nextLine();                     // Read line with break character (\n)

        System.out.println("Enter string:");
        String string = scanner.nextLine();

        scanner.close(); // SCANNER MUST BE CLOSED!!!
    }
}

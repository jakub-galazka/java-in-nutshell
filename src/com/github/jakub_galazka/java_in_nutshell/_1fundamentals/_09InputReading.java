package com.github.jakub_galazka.java_in_nutshell._1fundamentals;

import java.util.Locale;
import java.util.Scanner;

public class _09InputReading {

    private static void inputReading() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);           // Use . separator for floating points numbers
        /*
            Locale - is a Java class that represents a geographical, political, or cultural region
                     by encapsulating a language, country, and optional variant,
                     and is used as an identifier passed to locale-sensitive classes like NumberFormat and DateFormat
                     to format data — such as numbers, dates, and currencies — according to the conventions of a specific region or user,
                     for example, the number 1234567.89 is formatted as 1,234,567.89 in Locale.US but as 1.234.567,89 in Locale.GERMANY,
                     making it the foundation of internationalization (i18n) in Java.
         */

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
        /*
            Closing a Scanner releases the resource it wraps (stream, file, socket), preventing memory leaks.
            Not closing it leaves resource cleanup up to the garbage collector, which is non-deterministic.
         */
    }
}

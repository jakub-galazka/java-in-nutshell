package com.github.jakub_galazka.java_in_nutshell._1fundamentals;

public class _3Strings {

    // Constants for coloring text in the console
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    private static void strings() {
        // String - class datatype which is treated different from normally class datatype
        // IMPORTANT: strings in Java are immutable -> cannot change String after it is created (change -> new String is created)
        String stringValue = "This is a string";

        // Concatenation
        stringValue += " and this is more.";    // "This is a string and this is more."
        stringValue += 123;                     // "This is a string and this is more.123"

        boolean comparison = "A".equals("b");   // false
        int compareTo = "A".compareTo("B");     // -1 -> "A" < "B" | 0 => "A" == "B" | 1 -> "A" > "B" (alphabetically)

        String[] words = stringValue.split(" ");

        // ========================================================================================================================================================================================================

        // [since Java 15] Text block
        System.out.println("A\nB\nC\n");
        System.out.println("""
                A
                B
                C
                """);

        // ========================================================================================================================================================================================================

        // [since Win 10] Displaying colored text in console
        System.out.println("DEFAULT COLOR TEXT" + ANSI_BLUE + "BLUE TEXT" + ANSI_RESET + "DEFAULT COLOR TEXT");
    }
}

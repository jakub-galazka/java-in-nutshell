package com.github.jakub_galazka.java_in_nutshell._1fundamentals;

public class _3Strings {

    private static void strings() {
        /*
            String - class datatype which is treated different from normally class datatype
            IMPORTANT: strings in Java are immutable!
                       -> cannot change String after it is created
                          (change: new String is created)
         */
        String string = "This is a string";

        // Concatenation
        string += " and this is more.";           // "This is a string and this is more."
        string += 123;                            // "This is a string and this is more.123"

        // Strings comparison
        boolean comparison = "A".equals("b");     // false
        int compareTo = "A".compareTo("B");       // -1 -> "A" < "B" | 0 => "A" == "B" | 1 -> "A" > "B" (alphabetically)

        String[] words = string.split(" "); // ["This", "is", "a", "string", "and", "this", "is" "more.123"]

        // ========================================================================================================================================================================================================

        // [since Java 15] Text block
        System.out.println("A\nB\nC\n");
        System.out.println("""
                A
                B
                C
                """);
    }
}

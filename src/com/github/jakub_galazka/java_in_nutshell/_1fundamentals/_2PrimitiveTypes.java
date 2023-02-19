package com.github.jakub_galazka.java_in_nutshell._1fundamentals;

public class _2PrimitiveTypes {

    private static void primitiveTypes() {
        // 8 primitive types: byte, short, int, long, float, double, char, boolean
        // Primitive types wrapper classes: Byte, Short, Integer, Long, Float, Double, Char, Boolean

        // ========================================================================================================================================================================================================

        // byte -> 8 bits
        byte minByteValue = Byte.MIN_VALUE;     // -128
        byte maxByteValue = Byte.MAX_VALUE;     //  127

        // short -> 16 bits
        short minShortValue = Short.MIN_VALUE;  // -32768
        short maxShortValue = Short.MAX_VALUE;  //  32767

        // int -> 32 bits
        int minIntValue = Integer.MIN_VALUE;    // -2147483648
        int maxIntValue = Integer.MAX_VALUE;    //  2147483647

        // long -> 64 bits
        long minLongValue = Long.MIN_VALUE;     // -9223372036854775808
        long maxLongValue = Long.MAX_VALUE;     //  9223372036854775807
        long longValue = 1L;
        /*
            By default, Java consider a whole number as an int type:
                long tooBigIntValueAsLongType = 2147483647_123; -> ERROR: "Integer number too long"
            Unless the letter L on the end has added:
                long tooBigIntValueAsLongType = 2147483647_123L;
         */

        // ========================================================================================================================================================================================================

        // float -> 32 bits (single precision)
        float minFloatValue = Float.MIN_VALUE;      // 1.4E-45
        float maxFloatValue = Float.MAX_VALUE;      // 3.4028235E38
        float floatValue = 1f;
        /*
            By default, Java consider a floating points number as a double type:
                float floatValue = 1.5; -> ERROR: "Required type: float, Provided: double"
            Unless the letter f on the end has added:
                float floatValue = 1.5f;
            The letter f on the end is not required for whole numbers, but it is a GOOD PRACTISE!
         */

        // double -> 64 bits (double precision)
        // IMPORTANT: double is recommended to use because it is more precise and faster to process than float!
        double minDoubleValue = Double.MIN_VALUE;   // 4.9E-324
        double maxDoubleValue = Double.MAX_VALUE;   // 1.7976931348623157E308

        // ========================================================================================================================================================================================================

        maxIntValue += 1; // -2147483648 -> Overflow
        minIntValue += 1; //  2147483647 -> Underflow

        // Casting from default whole number type (int)
        int intValue = minIntValue / 2;
        byte byteValue = (byte) (minByteValue / 2);
        short shortValue = (short) (minShortValue / 2);

        // Whole numbers division
        int integerDivision = 3 / 2;                        // floor(3 / 2) = 1
        double doubleDivision = (double) 3 / 2;             // 3 / 2 = 1.5

        double underscoreNotation = 1_000_000.2_345_678;    // = 1000000.2345678

        // ========================================================================================================================================================================================================

        // char -> 16 bits (allows to store Unicode characters)
        /*
            Unicode - international encoding standard for use with different languages and scripts,
                      by which each letter, digit or symbol is assigned a unique numeric value
                      that applies across different platforms
         */
        char charValue = 'A';           // "" is for String
        char unicodeChar = '\u0041';    // A

        // char values can be increment or decrement (i.e. useful in loops)
        char firstAlphabetLetter = 'A';
        char secondAlphabetLetter = ++firstAlphabetLetter; // 'B' (pre-incrementation)

        // ========================================================================================================================================================================================================

        // boolean -> 1 bit
        boolean trueBooleanValue = true;
        boolean falseBooleanValue = false;
        boolean isBoolean = true; // GOOD PRACTISE: isVariableName
    }
}

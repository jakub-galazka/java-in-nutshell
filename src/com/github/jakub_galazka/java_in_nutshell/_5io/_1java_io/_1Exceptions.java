package com.github.jakub_galazka.java_in_nutshell._5io._1java_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
    public class Exception
    extends Throwable

    Exception - an event which occurs during the execution of a program that disrupts the normal flow of the program's instructions:
    ~ Exception and RuntimeException are classes defined in java.lang.
    ~ The different types of exceptions that can be called as subclasses of one of these 2 exceptions.
    ~ GOOD PRACTISE: when catching an exception specify which subclass of exception to catch.

    Call Stack - list of all the method calls at any particular point in a program's execution:
    ~ Each Thread of execution has its own Call Stack (and the Thread is shown as the first line of the Stack Trace).
    ~ So every time a new method is called,
      it is actually placed onto the stack and when a method returns it is removed from the stack.

    Throwing an exception:
    ~ Throwable constructor fills in the Stack Trace for the exception
        -> throw new Exception(); -> create new Exception object that contains the current Stack Trace.
    ~ When the exception itself is thrown, the Java Runtime then looks to see what can handle it.
      So it does that by working out back up the Call Stack, each method on the stack gets the exception.
      And if it does not handel it, then the exception gets passed on to the previous method on the stack and so on.
      The exception is said to propagate up the Call Stack,
      and it keeps getting passed to the calling methods until there is one that actually can handle the exception.
      If nothing handles the exception then the main Java entry point just prints the Stack Trace and the Java Runtime terminates.
*/

public class _1Exceptions {

    /*
        2 main approaches to dealing with errors in programming:
        * LBYL (look before you leap)
            -> test that an object is not null before use it (more common in Java).
        * EAFP (easy to ask for forgiveness than permission)
            -> go ahead and perform the operation then respond to an exception if something goes wrong.
    */

    private int divideLBYL(int x, int y) {
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    private int divideEAFP(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    /*
        Exceptions:
        ~ Checked (cannot be ignored)
            - These are the exceptions that are checked at compile time
                -> Handling: catch || throw them back up the Call Stack
        ~ Unchecked (can be ignored)
            - These are the exceptions that are not checked at compile time
                -> GOOD PRACTISE: to handle them

        HINT:
        ~ SIB cannot throw Checked Exceptions because SIB is executed when the class is loaded
            -> so there is no way for any code anywhere to catch any exceptions that are thrown.
        ~ The Unchecked Exception can be thrown in the SIB.
    */

    // IOException -> Checked Exception

    private void catchingCheckedException() {
        try {
            throwingBackCheckedException();
        } catch (IOException e) {
            // IMPORTANT: make sure that any code in the exception handler (catch block) does not cause exceptions itself
            e.printStackTrace();
        }
    }

    // Throw back Checked Exception to handle it in any parent method
    private void throwingBackCheckedException() throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("file_path.txt"));
        file.close();
    }

    // [since Java 7] Multi catch exceptions

    private void main() {
        try {
            int result = divide();
        } catch (ArithmeticException | NoSuchElementException e) {      // Method 1
            e.printStackTrace();
        }
    }

    private int divide() {
        int x, y;
        try {
            x = getInt();
            y = getInt();
            return x / y;
        } catch (NoSuchElementException e) {                            // Method 2
            throw new NoSuchElementException("No suitable input.");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Attempt to divide by zero.");
        }
    }

    private static int getInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return scanner.nextInt();
                /*
                    Using Ctrl+D - ASCI eot (end of transmission character)
                        -> that abruptly terminates any input
                        -> ERROR: NoSuchElementException
                 */
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Please enter a number using only the digits 0 to 9");
            }
        }
    }
}

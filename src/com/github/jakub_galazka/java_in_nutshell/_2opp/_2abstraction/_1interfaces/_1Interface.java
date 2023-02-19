package com.github.jakub_galazka.java_in_nutshell._2opp._2abstraction._1interfaces;

// Abstraction - defining the required functionality without actually implementing the details

/*
    Interface - itself is abstract and specifies methods that a particular class that implements the interface must implement
        -> an interface can extend another interface
*/
public interface _1Interface extends SuperInterface {

    // Variables in interface are always (by default): public static final
    int FIELD = 0;

    // No constructor (cannot be instantiated)

    // Methods in interface are (by default): public abstract
    void interfaceMethod();

    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /*
        [since Java 8] Interfaces can contain: default methods
            - instance methods with implementation -> KEYWORD: default
     */
    default void methodWithImplementation() {}

    /*
        [since Java 8] Interfaces can contain: static methods
            - static methods with implementation -> KEYWORD: static
     */
    static void staticMethod() {}

    /*
        [since Java 9] Interfaces can contain: private methods
            - used when two default methods in an interface share common code -> KEYWORD: private
     */
    private static void privateMethod() {}
}

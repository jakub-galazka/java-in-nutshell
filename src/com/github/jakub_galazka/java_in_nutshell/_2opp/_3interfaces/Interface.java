package com.github.jakub_galazka.java_in_nutshell._2opp._3interfaces;

/*
    Interface - itself is abstract and specifies methods that a particular class that implements the interface must implement
    -> an interface can extend another interface
*/
public interface Interface extends SuperInterface {

    // Interface can have only: public static final variables -> all variables are so by default
    int FIELD = 0;

    // No constructor

    // Methods in interface are: public abstract -> by default
    void interfaceMethod();

    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    // [since Java 8] Interfaces can contain default methods, in other words methods with implementation (mostly for backward compatibility) -> KEYWORD: default
    default void methodWithImplementation() {
        // ...
    }

    // [since Java 8] static methods are allowed
    static void staticMethod() {
        // ...
    }

    // [since Java 9] An interface can also contain private methods (commonly used when two default methods in an interface share common code)
    private void privateMethod() {
        // ...
    }
}

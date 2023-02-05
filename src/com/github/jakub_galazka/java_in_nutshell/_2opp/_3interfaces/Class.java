package com.github.jakub_galazka.java_in_nutshell._2opp._3interfaces;

// In Java a class can implement many interfaces
public class Class implements Interface, AnotherInterface {

    // All interfaces public abstract methods must be implemented (overridden)
    @Override
    public void superInterfaceMethod() {
        // ...
    }

    @Override
    public void interfaceMethod() {
        // ...
    }

    @Override
    public void anotherInterfaceMethod() {
        // ...
    }

    // default methods can be overridden
    @Override
    public void methodWithImplementation() {
        Interface.super.methodWithImplementation(); // OPTIONAL: interface super method call
        // ...
    }
}

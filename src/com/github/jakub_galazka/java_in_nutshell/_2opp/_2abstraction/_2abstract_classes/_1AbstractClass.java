package com.github.jakub_galazka.java_in_nutshell._2opp._2abstraction._2abstract_classes;

// Abstraction - defining the required functionality without actually implementing the details

// Abstract class can extend other abstract class (and implement interfaces)
public abstract class _1AbstractClass extends SuperAbstractClass {

    // No all fields have to be: public static final (diff from interface)
    private final int field;

    /*
        ~ Cannot directly instantiate the abstract class.
        ~ The abstract class is still a super class,
          so it's constructors run when someone makes an instance of the concrete subclass.
     */
    public _1AbstractClass(int field) {
        this.field = field;
    }

    // Method can have any visibility (diff from interface)
    protected abstract void method();

    public int getField() {
        return field;
    }
}

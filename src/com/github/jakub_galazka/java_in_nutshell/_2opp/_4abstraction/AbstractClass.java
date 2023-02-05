package com.github.jakub_galazka.java_in_nutshell._2opp._4abstraction;

// Abstraction - defining the required functionality without actually implementing the details

// Abstract class can extend other abstract class (and implement interfaces)
public abstract class AbstractClass extends SuperAbstractClass {

    // Fields are available -> difference between an abstract class and an interface
    private final int field;

    // Cannot directly instantiate the abstract class
    // The abstract class is still a super class, so it's constructors run when someone makes an instance of the concrete subclass
    public AbstractClass(int field) {
        this.field = field;
    }

    // Method can have any visibility
    public abstract void method();

    // No all methods have to be abstract like in interface
    public int getField() {
        return field;
    }
}

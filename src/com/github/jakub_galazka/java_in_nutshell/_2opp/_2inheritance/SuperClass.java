package com.github.jakub_galazka.java_in_nutshell._2opp._2inheritance;

public class SuperClass {

    private final int field;

    public SuperClass(int field) {
        this.field = field;
    }

    public void method() {
        System.out.println("SuperClass -> method()");
    }

    public int getField() {
        return field;
    }
}

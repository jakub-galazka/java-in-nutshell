package com.github.jakub_galazka.java_in_nutshell._2opp._1fundamentals._2inheritance;

public class _1SuperClass {

    private final int field;

    public _1SuperClass(int field) {
        this.field = field;
    }

    public void method() {
        System.out.println("_1SuperClass -> method()");
    }

    public int getField() {
        return field;
    }
}

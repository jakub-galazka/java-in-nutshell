package com.github.jakub_galazka.java_in_nutshell._2opp._1fundamentals._2inheritance;

/*
    Marking class final prevents the class from being sub-classed
    HINT: private Constructor prevent the class form being instantiated (i.e. Math class)
 */
public final class _5Final {

    private final int finalFiled;

    // final -> constant value (cannot be change after assignment)
    private static final double CONSTANT_VALUE = 3.14;

    /*
        final:
        Strictly speaking final fields are not actually constants,
        because they can be modified but only once, and any modification must be performed before the class constructor finished.
        So what that means is that we can assign a final field it's value either when we first declare it, or in the constructor.
    */
    public _5Final() {
        this.finalFiled = 0;
    }

    // Marking method as final prevents the method from being overridden
    public final void noOverrideMethode() {}
}

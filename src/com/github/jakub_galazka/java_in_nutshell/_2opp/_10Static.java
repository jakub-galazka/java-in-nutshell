package com.github.jakub_galazka.java_in_nutshell._2opp;

public class _10Static {

    private static int staticField;

    /*
        Static initialization block (SIB):
        * Static equivalent of constructors
        * Is only execute once when the class is first loaded into the project
        * Static final variable must be initialized by the time all static initialization blocks terminate
    */
    static {
        staticField = 0;
        System.out.println("first static initialization block called");
    }

    public _10Static() {
        System.out.println("constructor called");
    }

    // There can be many SIB -> they are called in the order they are declared in the class before the constructor
    static {
        System.out.println("second static initialization black called");
    }

    // GENERAL RULE: methods witch works on static fields also should be static
    public static int getStaticField() { return staticField; }

    public static void setStaticField(int staticField) {
        _10Static.staticField = staticField;
    }
}

package com.github.jakub_galazka.java_in_nutshell._2opp._1fundamentals._2inheritance;

// In Java a class can only inherit from one class at a time
public class _2Class extends _1SuperClass {

    private final int field;

    /*
        Composition (flexible alternative to inheritance)
        GENERAL RULE: before inheritance try to use composition first
     */
    private final CompositionClass compositionClass;

    /*
        ~ Use super() to call parent class constructor.
        ~ super(...); -> must be the first statement in constructor body.
        ~ The constructor can have a call to super() or this() but never both.
     */
    public _2Class(int superClassField, int subClassField) {
        super(superClassField);
        this.field = subClassField;
        this.compositionClass = new CompositionClass();
    }

    /*
        this - is used to access / call the current class members
        super - is used to access / call the parent class members
     */
    public int thisVsSuper() {
        return this.field + super.getField();
    }

    public int thisVsSuperAlternative() {
        return field + getField();
    }

    /*
        Polymorphism:
        the mechanism in OOP that allows actions to act differently
        based on the actual object that the action is being performed on

        _1SuperClass superClass = new _1SuperClass(0);
        superClass.method();                            // OUTPUT: _1SuperClass -> superClassMethode()
        _1SuperClass subClass = new _2Class(0, 0);
        subClass.method();                              // OUTPUT: _1SuperClass -> methode()
                                                                   _2Class -> methode() (overridden)
    */
    @Override
    public void method() {
        super.method(); // OPTIONAL: super class method call
        System.out.println("_2Class -> methode() (overridden)");
    }
}

package com.github.jakub_galazka.java_in_nutshell._3generics;

/*
    Generics:
    ~ Allow to create classes, interfaces and methods that take type as parameters called type parameters
      (classes and interfaces).
    ~ It makes the code stable by detecting the bugs at compile time.

    Bounded type parameters:
    ~ Upper bound - any class that extends from bound class or a subclass of bound class.
    ~ Java does allow multiple bounds, but the normal inheritance implements rules still applies
        -> you can only extend from a single class but multiple interfaces.
    ~ When specifying multiple bounds, the class must be listed first
        -> SYNTAX: public class GenericClass<T extends BoundClass & BoundInterface & ...>
    ~ In case of multiple bounds -> remember to include casting / checking code in methods.
 */

import java.util.ArrayList;

public class _1GenericClass<U extends OtherBoundClass, T extends _2BoundClass<U>> {

    private final ArrayList<T> arrayList = new ArrayList<>();

    public boolean add(T t) {
        if (arrayList.contains(t)) {
            return false;
        }
        arrayList.add(t);
        return true;
    }
}

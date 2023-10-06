package com.github.jakub_galazka.java_in_nutshell._3generics;

import java.util.ArrayList;

public class _3Main {

    public static void main(String[] args) {
        // Parametrize type
        ArrayList<String> arrayList = new ArrayList<>();

        OtherBoundFirstSubclass otherBoundFirstSubclass = new OtherBoundFirstSubclass();
        OtherBoundSecondSubclass otherBoundSecondSubclass = new OtherBoundSecondSubclass();

        _2BoundClass<OtherBoundFirstSubclass> firstBoundClass = new _2BoundClass<>();
        firstBoundClass.add(otherBoundFirstSubclass);
//        firstBoundClass.add(otherBoundSecondSubclass); -> ERROR: Required type: OtherBoundFirstSubclass | Provided: OtherBoundSecondSubclass

        _2BoundClass<OtherBoundSecondSubclass> secondBoundClass = new _2BoundClass<>();
//        secondBoundClass.add(otherBoundFirstSubclass); -> ERROR: Required type: OtherBoundSecondSubclass | Provided: OtherBoundFirstSubclass
        secondBoundClass.add(otherBoundSecondSubclass);

        _1GenericClass<OtherBoundFirstSubclass, _2BoundClass<OtherBoundFirstSubclass>> firstGenericClass = new _1GenericClass<>();
        firstGenericClass.add(firstBoundClass);
//        firstGenericClass.add(secondBoundClass); -> ERROR: Required type: OtherBoundFirstSubclass | Provided: OtherBoundSecondSubclass

        _1GenericClass<OtherBoundSecondSubclass, _2BoundClass<OtherBoundSecondSubclass>> secondGenericClass = new _1GenericClass<>();
//        secondGenericClass.add(firstBoundClass); -> ERROR: Required type: OtherBoundSecondSubclass | Provided: OtherBoundFirstSubclass
        secondGenericClass.add(secondBoundClass);
    }
}

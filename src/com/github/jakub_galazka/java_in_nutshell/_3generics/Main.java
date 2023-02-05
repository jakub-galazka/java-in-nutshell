package com.github.jakub_galazka.java_in_nutshell._3generics;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Parametrize type
        ArrayList<String> arrayList = new ArrayList<>();

        OtherBoundFirstSubclass otherBoundFirstSubclass = new OtherBoundFirstSubclass();
        OtherBoundSecondSubclass otherBoundSecondSubclass = new OtherBoundSecondSubclass();

        BoundClass<OtherBoundFirstSubclass> firstBoundClass = new BoundClass<>();
        firstBoundClass.add(otherBoundFirstSubclass);
//        firstBoundClass.add(otherBoundSecondSubclass); -> ERROR: Required type: OtherBoundFirstSubclass | Provided: OtherBoundSecondSubclass

        BoundClass<OtherBoundSecondSubclass> secondBoundClass = new BoundClass<>();
//        secondBoundClass.add(otherBoundFirstSubclass); -> ERROR: Required type: OtherBoundSecondSubclass | Provided: OtherBoundFirstSubclass
        secondBoundClass.add(otherBoundSecondSubclass);

        GenericClass<OtherBoundFirstSubclass, BoundClass<OtherBoundFirstSubclass>> firstGenericClass = new GenericClass<>();
        firstGenericClass.add(firstBoundClass);
//        firstGenericClass.add(secondBoundClass); -> ERROR: Required type: OtherBoundFirstSubclass | Provided: OtherBoundSecondSubclass

        GenericClass<OtherBoundSecondSubclass, BoundClass<OtherBoundSecondSubclass>> secondGenericClass = new GenericClass<>();
//        secondGenericClass.add(firstBoundClass); -> ERROR: Required type: OtherBoundSecondSubclass | Provided: OtherBoundFirstSubclass
        secondGenericClass.add(secondBoundClass);
    }
}

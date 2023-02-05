package com.github.jakub_galazka.java_in_nutshell._3generics;

import java.util.ArrayList;

// Object that implement Comparable interface can be quickly sorted by using the static sort method of the Collections class -> Collections.sort()
public class BoundClass<T extends OtherBoundClass> implements Comparable<BoundClass<T>> {

    private int field;
    private final ArrayList<T> arrayList = new ArrayList<>();

    public boolean add(T t) {
        if (arrayList.contains(t)) {
            return false;
        }
        arrayList.add(t);
        return true;
    }

    public int getField() {
        return field;
    }

    /*
        RETURN:
         1  -> if (this > object)
         0  -> if (this == object)
        -1  -> if (this < object)
    */
    @Override
    public int compareTo(BoundClass<T> o) {
        return Integer.compare(field, o.getField());
    }
}

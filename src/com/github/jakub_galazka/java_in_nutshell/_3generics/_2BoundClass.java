package com.github.jakub_galazka.java_in_nutshell._3generics;

import java.util.ArrayList;

/*
    Object that implement Comparable interface can be quickly sorted by using the static sort method of the Collections class
        -> Collections.sort()
 */
public class _2BoundClass<T extends OtherBoundClass> implements Comparable<_2BoundClass<T>> {

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
    public int compareTo(_2BoundClass<T> o) {
        return Integer.compare(field, o.getField());
    }
}

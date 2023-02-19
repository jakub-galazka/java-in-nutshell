package com.github.jakub_galazka.java_in_nutshell._4java_collections;

/*
    Immutable class:
    ~ Cannot be changed once it is created -> great way to increase encapsulation.
    ~ Could be used as a key to a map with no ill effects.

    The Strategy for Defining Immutable Objects:
    https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html
 */

import java.util.HashMap;
import java.util.Map;

// IMMUTABLE STRATEGY: do not allow class to be subclassed -> KEYWORD: final
public final class _9ImmutableClass {

    // IMMUTABLE STRATEGY: make all fields: private final
    private final int field;
    private final Map<Integer, Integer> map;


    // IMMUTABLE STRATEGY: do not provide methods that modify the mutable objects
    public _9ImmutableClass(int field, Map<Integer, Integer> map) {
        this.field = field;
        if (map != null) {
            this.map = new HashMap<>(map);
        } else {
            this.map = new HashMap<>();
        }
    }

    public int getField() {
        return field;
    }


    // IMMUTABLE STRATEGY: do not share references to mutable objects
    public Map<Integer, Integer> getMap() {
        return new HashMap<>(map);
    }

    // IMMUTABLE STRATEGY: do not provide setters
}

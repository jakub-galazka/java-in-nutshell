package com.github.jakub_galazka.java_in_nutshell._4java_collections;

import java.util.*;

public class _1List {

    /*
        java.util
        public interface List<E>
        extends Collection<E>

        ~ Provides the facility to maintain the ordered collection.
        ~ Contains the index-based methods to insert, update, delete and search the elements.
        ~ Allow duplicate elements.
        ~ Allow null elements.
    */
    private static void list() {
        // GOOD PRACTISE: using interface types
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
    }
}

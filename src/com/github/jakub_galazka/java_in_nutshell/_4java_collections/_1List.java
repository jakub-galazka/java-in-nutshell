package com.github.jakub_galazka.java_in_nutshell._4java_collections;

import java.util.*;

public class _1List {

    /*
        java.util
        public interface List<E>
        extends Collection<E>

        * List in Java provides the facility to maintain the ordered collection.
        * It contains the index-based methods to insert, update, delete and search the elements.
        * Allow the duplicate elements.
        * Allow the null elements.
    */
    private static void list() {
        // GOOD PRACTISE: using interface types
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();
    }
}

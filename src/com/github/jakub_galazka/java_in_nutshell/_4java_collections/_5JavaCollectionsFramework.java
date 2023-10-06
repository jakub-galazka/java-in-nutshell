package com.github.jakub_galazka.java_in_nutshell._4java_collections;

import java.util.*;

/*
    ~ Java Collections is a framework that provides unified ready-made architecture
      (set of classes and interfaces) for storing and manipulating the group of objects (collections).
    ~ Java Collections can achieve all the operations that you perform on a data such as
      inserting, sorting, searching, manipulating, and deleting.

    Core elements of the Collections Framework:
    ~ Interfaces:
        - Represents collections, including the List interface and aggregate operations (i.e. iterators).
        - Allows the framework to be extended.
        - Defines methods for all the fundamental operations that really are required for the various collection type.
    ~ Implementations
        - concrete implementations of the interface, like the ArrayList and LinkedList classes.
    ~ Algorithms
        - Java JDK provides a range of polymorphic algorithms that work on Collection objects,
          technically speaking on object that implement the Collection interface, and they provide reusable functionality.

    At the top level of the framework is Collections class:

    java.util
    public class Collections
    extends Object

    ~ Exposes static methods that either operate on collections such as the Collections.sort()
      or they also return Collection objects such as the Collections.list().

    One of the design goals of the framework was that there should be good interoperability amongst various collections.
    So not just one's included in the framework, but literally anything that may also be created in the future
    that is a reasonable representation of a collection.
    That also includes arrays, but arrays themselves could not be made part of the framework without changing the Java language.
    However, the framework does include methods that enable Collection to be moved into arrays and vice versa and
    additionally methods to allow arrays to be viewed as Collection.
*/

public class _5JavaCollectionsFramework {

    private final List<Integer> list = new ArrayList<>();
    // Really generic -> so the advantage doing that is enables to use any of the Collection classes to hold our seats
    private final Collection<Integer> firstReallyGenericList = new HashSet<>();
    private final Collection<Integer> secondReallyGenericList = new LinkedHashSet<>();
    private final Collection<Integer> errorList = new TreeSet<>();
    /*
        ERROR: ClassCastException (IF: objects in Collection does not implement Comparable)
            -> TreeSet implements SortedSet which is one level down. Actually what it does it is NavigableSet which extends SortedSet.
            It is got an additional requirement that elements in it must contain or must be Comparable (that how the set is sorted).

        Moving down the hierarchy, the interfaces become more specialized,
        so we can only replace classes with other classes that implement one of the core Collection interfaces at the same level.

        https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html
     */

    private void collectionsStaticMethods() {
        Collections.sort(list);
        Collections.shuffle(list);
        Collections.reverse(list);
        Collections.swap(list, 0, 1);
        Collections.binarySearch(list, 0);
    }
}

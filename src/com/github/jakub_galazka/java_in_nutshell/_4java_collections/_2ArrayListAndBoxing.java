package com.github.jakub_galazka.java_in_nutshell._4java_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _2ArrayListAndBoxing {

    /*
       java.util
       public class ArrayList<E>
       extends AbstractList<E>
       implements List<E>, RandomAccess, Cloneable, Serializable

       * Resizable-array implementation of the List interface (like an array, but there is no size limit -> dynamic array).
       * Initialized by the size. The size is dynamic in the array list, which varies according to the elements getting added or removed from the list.
       * Maintains insertion order.
       * Can contain duplicate elements.
       * Is non synchronized.
       (Synchronization in Java is the capability to control the access of multiple threads to any shared resource.
       Java Synchronization is better option where we want to allow only one thread to access the shared resource).
       * It is required to use the wrapper classes for the primitive types.
       * Allows random access because the array works on an index basis.
       * In ArrayList, manipulation (insert, remove) is a little slower than the LinkedList in Java because a lot of shifting needs to occur if any element is removed from the array list.
    */
    private static void arrayList() {
        ArrayList<String> arrayList = new ArrayList<>();

        String str = "string";

        // add, get, set, remove
        arrayList.add(str);
        str = arrayList.get(0);
        arrayList.set(0, "anotherString");
        boolean removeSuccess = arrayList.remove(str);          // false

        // Other methods
        int size = arrayList.size();                            // 1
        int indexOfStr = arrayList.indexOf(str);                // -1
        boolean isStrInArrayList = arrayList.contains(str);     // false

        // ArrayList to Array
        String[] array = new String[arrayList.size()];
        arrayList.toArray(array);

        // Array to ArrayList
        ArrayList<String> arrayListOfArray = new ArrayList<>();
        Collections.addAll(arrayListOfArray, array);

        // Shallow copy - coping Collection but NOT objects inside it
        // 1. method
        ArrayList<String> shallowCopyMethod1 = new ArrayList<>(arrayList);
        // 2. method
        ArrayList<String> shallowCopyMethod2 = new ArrayList<>();
        shallowCopyMethod2.addAll(arrayList);

        // TODO: Deep copy - copying Collection and objects inside it
        List<String> deepCopy = new ArrayList<>(arrayList.size());  // ERROR: IndexOutOfBoundsException -> it set capacity of the array list but initially containing none
        Collections.copy(deepCopy, arrayList);                      // PARAMETERS: destination, source -> the destination has to have size of source Collection to copy

        // Wrapper classes for primitive types
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        integerArrayList.add(Integer.valueOf(0));                 // Boxing
        integerArrayList.add(0);                                    // Autoboxing
        int unboxedInt = integerArrayList.get(0).intValue();        // Unboxing
        int autoUnboxedInt = integerArrayList.get(0);               // Auto unboxing
    }
}

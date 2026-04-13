package com.github.jakub_galazka.java_in_nutshell._4java_collections;

import java.util.ArrayList;
import java.util.Collections;

public class _2ArrayListAndBoxing {

    /*
       java.util
       public class ArrayList<E>
       extends AbstractList<E>
       implements List<E>, RandomAccess, Cloneable, Serializable

       ~ Resizable-array implementation of the List interface.
       ~ The size is dynamic and changes depending on items added or removed from the list
         (when initialized: a default capacity of 10 is assigned).
       ~ Maintains insertion order.
       ~ Allow duplicate elements.
       ~ Allow null elements.
       ~ Can be used as a list only.
       ~ Allows random access (works on an index basis).
       ~ Requires the use of wrapper classes for primitive types.
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
        // 1.
        ArrayList<String> shallowCopy1 = new ArrayList<>(arrayList);
        // 2.
        ArrayList<String> shallowCopy2 = new ArrayList<>();
        shallowCopy2.addAll(arrayList);

        // Wrapper classes for primitive types
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        // Boxing
        integerArrayList.add(Integer.valueOf(0));
        // Autoboxing
        integerArrayList.add(0);
        // Unboxing
        int unboxedInt = integerArrayList.get(0).intValue();
        // Auto unboxing
        int autoUnboxedInt = integerArrayList.get(0);
    }
}

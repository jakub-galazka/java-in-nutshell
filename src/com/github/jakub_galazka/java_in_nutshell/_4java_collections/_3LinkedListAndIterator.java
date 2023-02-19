package com.github.jakub_galazka.java_in_nutshell._4java_collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class _3LinkedListAndIterator {

    /*
     java.util
     public class LinkedList<E>
     extends AbstractSequentialList<E>
     implements List<E>, Deque<E>, Cloneable, Serializable

     ~ Uses a doubly-linked list data structure to store the elements.
     ~ Maintains insertion order.
     ~ Allow duplicate elements.
     ~ Allow null elements.
     ~ Can be used as a list, stack or queue.
 */
    private static void linkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        /*
            java.util
            Interface Iterator<E>

            ~ Interface to iterate through a collection of objects one by one.
            ~ One of the Java cursors, considered the Universal Cursor for the Collection API
              (as it is appropriate for all the classes of the Collection Framework).

            Advantages:
            ~ Allows the READ and REMOVE operations.
            ~ Applicable to any of the classes of the Collection Framework.
            ~ Working with a for loop: cannot modernize (add / remove) the Collection.
              Using the Iterator: can simply update the Collection.
            Disadvantages:
            ~ Only preserves the iteration in the forward direction (uni-directional).
            ~ Supports only sequential iteration.
        */
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            System.out.println(next); // .next() -> returns the actual entry and moves to the next entry
            if (next == 3) {
                iterator.remove();
            }
        } // OUTPUT: 1 2 3 4 5
        System.out.println(linkedList); // OUTPUT: [1, 2, 4, 5]

        /*
            java.util
            public interface ListIterator<E>
            extends Iterator<E>

            ~ Allows traverse the list in either direction.
            ~ Has no current element, its cursor position always lies between
              the element that would be returned by a call to previous() and
              the element that would be returned by a call to next().
        */
        ListIterator<Integer> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        } // OUTPUT: 1 2 4 5

        while (listIterator.hasPrevious()) {
            int previous = listIterator.previous();
            System.out.println(previous);
            if (previous == 4) {
                listIterator.remove();
            }
        } // OUTPUT: 5 4 2 1
        System.out.println(linkedList); // OUTPUT: [1, 2, 5]
    }
}

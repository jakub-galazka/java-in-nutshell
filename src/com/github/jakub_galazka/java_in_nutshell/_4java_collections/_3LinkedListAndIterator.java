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

     * Uses a doubly-linked list data structure to store the elements.
     * Maintains insertion order.
     * Can contain duplicate elements.
     * Non synchronized.
     * In Java LinkedList class, manipulation (insert, remove) is fast because no shifting needs to occur.
     * Can be used as a list, stack or queue.
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

            * Interface that is practiced in order to iterate over a collection of Java object components entirety one by one.
            * One of the Java cursors, considered the Universal Cursor of Java for the Collection API as it is appropriate for all the classes of the Collection framework.

            Advantages:
            * Allows the READ and REMOVE operations.
            * Can be applied to any of the classes of the Collection framework.
            * If a user is working with a for loop, they cannot modernize (add / remove) the Collection, whereas, if they use the Iterator, they can simply update the Collection.
            Disadvantages:
            * Only preserves the iteration in the forward direction (uni-directional iterator).
            * In comparison with the Spliterator, Iterator does not support traversing elements in the parallel pattern which implies that Iterator supports only sequential iteration.
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

            * An iterator for lists that allows the programmer to:
                - Traverse the list in either direction.
                - Modify the list during iteration.
                - Obtain the iterator current position in the list.
            * A ListIterator has no current element, its cursor position always lies between the element that would be returned by a call to previous() and the element that would be returned by a call to next().
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

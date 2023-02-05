package com.github.jakub_galazka.java_in_nutshell._4java_collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    java.util
    public interface Set<E>
    extends Collection<E>

    * Set has no defined ordering (the Oracle documentation defines it as chaotic) and cannot contain duplicates
        -> GOOD PRACTISE: use Sets to ensure that there is no duplicates in Collection.
    * There are ordered Sets, such as the LinkedHashSet and TreeSet.
    * There is no way to retrieve an item from a Set. You can check if something exists, and you can iterate over all the elements.
    * Using MUTABLE objects as elements in a Set can cause problems.
    * Best preforming implementation of a Set interface is the HashSet class and that uses hashes to store the items (like the HashMap class):
        - HashSet implementation currently uses a HashMap.
        - Set can be implemented using a map, so you could actually use the corresponding Map object and use only the keys ignoring the values. So this is what HashSet does.
        - And whenever an element is added to the Set, it becomes a key in the underlying HaspMap and a dumpy object is stored as the value.
    * Operations on Set are very fast.
    * The Java Collection Set types allow the usual Set operations such as union and intersection (mathematical notion).
*/

public class _10Sets {

    private static void setsTheory() {
        Set<String> firstSet = new HashSet<>();
        Set<String> secondSet = new HashSet<>();

        String firstSentence = "All roads lead to Rome";
        String secondSentence = "Rome wasn't built in a day";

        /*
            Java Collections interface suggest that all classes that implement Collection should provide two standard constructors.
            First one should take no arguments to create an empty Collection.
            And the other one also takes a Collection argument to initialize the new Collection with all the items in the Collection that is passed to the constructor.
         */
        String[] firstSentenceWords = firstSentence.split(" ");
        String[] secondSentenceWords = secondSentence.split(" ");
        // Arrays.asList() -> bridge between the array-based and collection-based APIs for initializing Collections (no Collection literals in Java)
        firstSet.addAll(Arrays.asList(firstSentenceWords));
        secondSet.addAll(Arrays.asList(secondSentenceWords));

        // Union - of two or more sets is a set containing all the elements of the sets -> addAll()
        Set<String> union = new HashSet<>(firstSet);
        union.addAll(secondSet);

        // Intersection - of two sets is the set containing all elements of first set that also belong to second set or equivalently -> retainAll()
        Set<String> intersection = new HashSet<>(firstSet);
        intersection.retainAll(secondSet);

        // Asymmetric difference - remove all elements of one Set from another -> removeAll()
        Set<String> asymmetricDiff = new HashSet<>(firstSet);
        asymmetricDiff.retainAll(secondSet);

        // Symmetric difference - is the elements that appear in one set or the other but not both (there is no implementation in Java) -> (Union - Intersection)
        Set<String> symmetricDiff = new HashSet<>(firstSet);
        Set<String> intersectionForSymmetricDiff = new HashSet<>(firstSet);

        symmetricDiff.addAll(secondSet);                        // Union
        intersectionForSymmetricDiff.retainAll(secondSet);      // Intersection
        symmetricDiff.retainAll(intersectionForSymmetricDiff);  // (Union - Intersection)

        // Test is one set is superset of another -> containsAll()
        if (secondSet.containsAll(firstSet)) {
            System.out.println("secondSet is a subset of firstSet");
        }
    }
}

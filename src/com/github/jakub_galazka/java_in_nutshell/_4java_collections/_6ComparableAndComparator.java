package com.github.jakub_galazka.java_in_nutshell._4java_collections;

import java.util.Comparator;

public class _6ComparableAndComparator implements Comparable<_6ComparableAndComparator> {

    private int comparableFirstValue;
    private int comparableSecondValue;

    private int comparatorFirstValue;
    private int comparatorSecondValue;

    /*
        Comparator interface:
        ~ Defines a single method called compare.
        ~ Unlike Comparable the object to be sorted do not have to implement Comparator.
          Instead, an object of type Comparator can be created with compare method
          that can sort the object that we're interested in.
        ~ More than one Comparator can be created, and it allows for objects to be sorted in different ways.
     */
    public static Comparator<_6ComparableAndComparator> ORDER_FIRST;
    public static Comparator<_6ComparableAndComparator> ORDER_SECOND;

    static {
        ORDER_FIRST = new Comparator<_6ComparableAndComparator>() {
            @Override
            public int compare(_6ComparableAndComparator o1, _6ComparableAndComparator o2) {
                return Integer.compare(o1.comparatorFirstValue, o2.comparatorSecondValue);
            }
        };

        ORDER_SECOND = new Comparator<_6ComparableAndComparator>() {
            @Override
            public int compare(_6ComparableAndComparator o1, _6ComparableAndComparator o2) {
                return Integer.compare(o1.comparatorSecondValue, o2.comparatorSecondValue);
            }
        };
    }

    @Override
    public int compareTo(_6ComparableAndComparator o) {
        return Integer.compare(comparableFirstValue + comparatorSecondValue, o.comparableFirstValue + o.comparableSecondValue);
    }

    /*
        Usage:
        List<ComparableAndComparator> comparableAndComparatorList = new ArrayList<>();
        Collections.sort(comparableAndComparatorList);
        Collections.sort(comparableAndComparatorList, ComparableAndComparator.ORDER_FIRST);     // comparableAndComparatorList.sort(ComparableAndComparator.ORDER_FIRST);
        Collections.sort(comparableAndComparatorList, ComparableAndComparator.ORDER_SECOND);    // comparableAndComparatorList.sort(ComparableAndComparator.ORDER_SECOND);
    */
}

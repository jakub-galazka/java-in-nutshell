package com.github.jakub_galazka.java_in_nutshell._4java_collections;

import java.util.Collections;
import java.util.List;

public class _7BinarySearch {

    private final List<Integer> list;

    public _7BinarySearch(List<Integer> list) {
        this.list = list;
    }

    /*
        BinarySearch:
        The fastest way to find the item in a sorted list.
        It works by checking the element in the mid-point of the list.
        So the method basically plays higher or lower with the list.
        So if the middle element is greater than the item that we are looking for,
        then it knows the one we want, must be in the first part of the list.
        So the way it does then it preforms a binary search on that half of the list in the same way.
        So the list of elements is reduced to half each time.
     */
    public boolean binarySearch(int toSearch) {
        int index = Collections.binarySearch(list, toSearch); // RETURN: index of founded item / -1 (IF: item not found)

        if (index >= 0) {
            System.out.println(list.get(index));
            return true;
        }
        return false;
    }

    public boolean binarySearchAlgo(int toSearch) {
        int low = 0;
        int high = list.size() - 1;

        while (low != high) {
            int mid = (low + high) / 2;
            int midValue = list.get(mid);
            int cmp = Integer.compare(toSearch, midValue);

            if (cmp < 0) {
                high = mid - 1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                System.out.println(midValue);
                return true;
            }
        }
        return false;
    }
}

package com.github.jakub_galazka.java_in_nutshell._4java_collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class _8Maps {

    /*
        java.util
        Interface Map<K,V>

        ~ Part of Collections Framework even though it is not a true Collection
          (https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html).
        ~ Maps keys to values.
        ~ Does NOT allow duplicate keys (each key can map to at most one value).
        ~ Allows duplicate values.
        ~ HashMap and LinkedHashMap implementations allow null keys and values.
        ~ TreeMap does NOT allow null keys or values.
        ~ Maps are generic: they take 2 types, one for the key, and one for the value.
          BAD PRACTISE: use raw Maps where the types are not specified.
        ~ Map is useful if you have to search, update or delete elements on the basis of a key.

        Classes that implement the Map interface (https://www.javatpoint.com/java-map):
        ~ HashMap and LinkedHashMap
        ~ TreeMap (implements SortedMap interface)
    */
    private void maps() {
        Map<String, String> map = new HashMap<>();                     // There is no specific order in HashMap -> unordered collection

        // Keys are unique but do not have to be immutable, but SHOULD BE!
        // map.put(key); -> null (IF: there was NOT the key in map) / [prev value] (IF: there was the key in map)
        map.put("key1", "value1");                                        // null
        map.put("key1", "value11");                                       // value1
        map.put("key2", "value2");

        String key1Value = map.get("key1");

        // map.remove(key); -> null (IF: there was NOT the key in map) / [prev value] (IF: there was the key in map)
        map.remove("key1");                                          // value11
        map.remove("key1", "value1");                                     // true / false (remove key only when it is mapped to a certain value)

        // Replace entry for specific key if it is already mapped to a value
        // map.replace(key, value); -> null (IF: there was not the key-value pair) / [prev value] (IF: there was the key-value pair)
        map.replace("key2", "value22");                                   // value2
        map.replace("key2", "value2");                                    // value22
        map.replace("key2", "value22", "value2");   // true / false

        boolean isKey1 = map.containsKey("key1");                         // true / false

        // Iterating over Map
        // keySet() -> Set of all the keys in the Map
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        // entrySet() -> Set of all the key-value pairs int the Map
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + ": " + value);
        }
    }

    private final Map<String, MapObject> map = new HashMap<>();

    /*
        It is important that access to object in collection is restricted,
        then avoid returning any sort of collection that contains the actual objects
     */
    public Map<String, Integer> Items() {
        Map<String, Integer> mapObjects = new HashMap<>();
        for (Map.Entry<String, MapObject> entry : map.entrySet()) {
            mapObjects.put(entry.getKey(), entry.getValue().getField());
        }
        return Collections.unmodifiableMap(mapObjects);
        /*
            RETURN: the Map that cannot be modified (faster than creating a copy):
            ~ Unmodifiable collections object are just a view into the underlying collection.
            ~ Only the collection itself is unmodifiable.
         */
    }

    static class MapObject {

        private final int field;

        public MapObject(int field) {
            this.field = field;
        }

        public int getField() {
            return field;
        }
    }
}

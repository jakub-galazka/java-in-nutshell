package com.github.jakub_galazka.java_in_nutshell._5io._1java_io;

import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class _3Location implements Serializable {

    @Serial // [since Java 14]
    private static final long serialVersionUID = 1L;

    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;
    /*
        LinkedHashMap implements Serializable interface
            -> IMPORTANT: if we want to serialize objects, the entire contents of the exits field will also be serialized
     */

    public _3Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits != null) {
            this.exits = new LinkedHashMap<>(exits);
        } else {
            this.exits = new LinkedHashMap<>();
        }
        this.exits.put("Q", 0);
    }

    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new LinkedHashMap<>(exits);
    }
}

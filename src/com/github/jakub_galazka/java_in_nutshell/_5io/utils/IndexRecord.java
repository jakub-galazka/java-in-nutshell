package com.github.jakub_galazka.java_in_nutshell._5io.utils;

public class IndexRecord {

    private int offset;
    private int length;

    public IndexRecord(int offset, int length) {
        this.offset = offset;
        this.length = length;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

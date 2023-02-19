package com.github.jakub_galazka.java_in_nutshell._2opp._1fundamentals._1classes;

// Scope - refers to the visibility of a class, member or variable (i.e. access modifiers)
public class _2Scope {

    private final int filed = 0;

    /*
        Concept of enclosing blocks:
        Java checking the current block of code to see if the variable was actually declare there.
        If it is declared there, then that variable is used, but if there is no such declaration,
        then Java actually checks any block that encloses the current one to see if there is a declaration there
        (it keeps doing this working backwards until it finds the variable declaration).
    */
    public void enclosingBlock() {
        int filed = 1;
        System.out.println(filed); // OUTPUT: 1
    }
}

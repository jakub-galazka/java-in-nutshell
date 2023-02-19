package com.github.jakub_galazka.java_in_nutshell._2opp._1fundamentals._1classes;

// Class - the blueprint for objects
// Class members - variables and methods in the class
// Instance - each object crated by class -> KEYWORD: new
// Reference (to object in memory) - name of object variable (copied reference still point to the same object)

public class _1Class {

    /*
        Encapsulation - the mechanism that allows to restrict access to certain components in the objects
        (protect the members of a class from external access) -> KEYWORD: private
     */
    // Member variables / fields
    private int memberVariable;
    private int field;

    /*
        Default constructor (with no arguments):
        ~ Use this() to call a constructor from another overloaded constructor in the same class
          (to set default fields values by / in default constructor).
        ~ this(...); -> can be used only in constructor, and it must be the first statement in constructor body.
        ~ Java compiler automatically creates the default constructor in case no constructor is present in the Java class.
        ~ Even in the abstract class the compiler adds the default constructor!
          (the abstract class cannot be instantiated using KEYWORD: new)
     */
    public _1Class() {
        this(0, 0);
    }

    /*
        Constructors chaining
        GENERAL RULE: don't call any other methods other than another constructor
     */
    public _1Class(int memberVariable) {
        this(memberVariable, 0);
    }

    public _1Class(int memberVariable, int field) {
        this.memberVariable = memberVariable;
        this.field = field;
    }

    // Factory method pattern
    public _1Class factoryMethod(int memberVariable, int field) {
        return new _1Class(memberVariable, field);
    }

    // Getters and setters
    public int getMemberVariable() {
        return memberVariable;
    }

    public void setMemberVariable(int memberVariable) {
        this.memberVariable = memberVariable;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    // DEFAULT: packageName.className@numberRepresentMemoryLocation
    @Override
    public String toString() {
        return "Class{" +
                "memberVariable=" + memberVariable +
                ", field=" + field +
                '}';
    }
}

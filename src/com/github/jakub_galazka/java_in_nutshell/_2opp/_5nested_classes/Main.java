package com.github.jakub_galazka.java_in_nutshell._2opp._5nested_classes;

/*
    4 nested class types:
    * Static nested class - no access to outer class members
    * Nonstatic nested class - access to outer class members
    * Local class - are declared inside a block, such as a method or if statement, and their scope is restricted completely to that particular block
    * Anonymous class (local class without name) - declared and instantiated at the same time, and they are used when a local class is required only once
*/

public class Main {

    public static void main(String[] args) {
        // To create instance of nonstatic nested inner class the instance of outer class is needed -> different to static nested class
        OuterClass outerClass = new OuterClass();
        OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass(0);
        OuterClass.NonstaticNestedClass nonstaticNestedClass = outerClass.new NonstaticNestedClass(0);

        // Local class
        class LocalClass {

            private int field;

            public LocalClass(int field) {
                this.field = field;
            }

            public int getField() {
                return field;
            }

            public void setField(int field) {
                this.field = field;
            }
        }

        // Anonymous class
        outerClass.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("onClick() (implementation)");
            }
        });
    }
}

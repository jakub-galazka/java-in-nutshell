package com.github.jakub_galazka.java_in_nutshell._2opp._5nested_classes;

public class OuterClass {

    private int memberVariable;
    private int field;

    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void onClick() {
        onClickListener.onClick();
    }

    public int scopeAccess() {
        // The containing class can also access all the methods and fields of a contained class even if they are marked as private
        NonstaticNestedClass nonstaticNestedClass = new NonstaticNestedClass(0);
        StaticNestedClass staticNestedClass = new StaticNestedClass(0);
        return nonstaticNestedClass.field + staticNestedClass.field;
    }

    // Static nested class
    public static class StaticNestedClass {

        private final int field;

        public StaticNestedClass(int field) {
            this.field = field;
        }
    }

    // Nonstatic nested class
    // Generally nonstatic inner class is private
    public class NonstaticNestedClass {

        private final int field; // Shadowing field from OuterClass (to refer field from OuterClass -> OuterClass.this.field)

        public NonstaticNestedClass(int field) {
            this.field = field * OuterClass.this.field * memberVariable; // Instances of nonstatic inner class has access to all the methods and fields of the outer class (even those mark as private)
        }
    }
}

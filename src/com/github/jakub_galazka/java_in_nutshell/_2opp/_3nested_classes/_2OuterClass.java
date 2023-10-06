package com.github.jakub_galazka.java_in_nutshell._2opp._3nested_classes;

public class _2OuterClass {

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
        /*
            The containing class can access all the methods and fields of the contained class
            (even if they are marked as private)
         */
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

    /*
        Nonstatic nested class
        GENERAL RULE: nonstatic inner class is private
     */
    public class NonstaticNestedClass {

        /*
            Shadowing field from OuterClass
            (to refer field from OuterClass: OuterClass.this.field)
         */
        private final int field;

        public NonstaticNestedClass(int field) {
            /*
                The nonstatic inner class can access all the methods and fields of the outer class
                (even if they are marked as private)
             */
            this.field = field * _2OuterClass.this.field * memberVariable;
        }
    }
}

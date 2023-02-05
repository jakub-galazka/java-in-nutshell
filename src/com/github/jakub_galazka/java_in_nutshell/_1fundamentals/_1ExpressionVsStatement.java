package com.github.jakub_galazka.java_in_nutshell._1fundamentals;

public class _1ExpressionVsStatement {

    private static void expressionVsStatement() {
        System.out.println("Hello World!"); // "Hello World!" -> Literal string
        int integer = 0;                    // 0              -> Literal number
        // Literal value is an expression

        int equation = 1 + 2;               // Declaration statement

        // int equation = 1 + 2; -> Statement - the complete command to be executed (can include 1 or more expressions)
        // equation = 1 + 2      -> Expression - the construct that evaluates to a single value (variables, values and operators)

        // Expression | Statements
        int value = 0;                              // value = 0      | int value = 0;
        boolean isTrue = false;                     // isTrue = false | boolean isTrue = false;
        if (!isTrue) {                              // !isTrue        | if (!isTrue)
            System.out.println("It's false!");      // "It's false!"  | System.out.println("It's false!");
            value = 1;                              // value = 1      | value = 1;
        }
    }
}

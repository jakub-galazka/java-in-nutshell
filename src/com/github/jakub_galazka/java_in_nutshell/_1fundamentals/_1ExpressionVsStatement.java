package com.github.jakub_galazka.java_in_nutshell._1fundamentals;

public class _1ExpressionVsStatement {

    private static void expressionVsStatement() {
        int number = 1 + 2;
        /*
            int number = 1 + 2;
                -> Statement - the complete command to be executed (can include 1 or more expressions)

            number = 1 + 2
                -> Expression - the construct that evaluates to a single value
                                (consists of: variables, values and operators)
          */

        // Expression | Statements
        int value = 0;                              // value = 0      | int value = 0;
        boolean isTrue = false;                     // isTrue = false | boolean isTrue = false;
        if (!isTrue) {                              // !isTrue        | if (!isTrue)
            System.out.println("It's false!");      // "It's false!"  | System.out.println("It's false!");
            value = 1;                              // value = 1      | value = 1;
        }
    }
}

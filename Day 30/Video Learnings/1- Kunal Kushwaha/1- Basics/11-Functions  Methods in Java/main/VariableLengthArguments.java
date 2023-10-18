package com.abdullah;

import java.util.Arrays;

public class VariableLengthArguments {
    public static void main(String[] args) {
        // You can give any length of numbers that you want to this function
        func(1, 2, 3, 4, 5, 12, 34, 12);
        func2(2, 3, "Hello World");
    }

    // You can also do it for String, char and other data types
    static void func(int... v) {
        System.out.println(Arrays.toString(v));
    }

    // Taking multiple or mix arguments
    static void func2(int a, int b, String... v) {
        System.out.println(a + " " + b + " " + Arrays.toString(v));
    }
}

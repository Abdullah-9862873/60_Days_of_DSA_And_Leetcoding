package com.abdullah;

public class FunctionOverloading {
    public static void main(String[] args) {
        func(12); // Will run the first function
        func("Abdullah"); // Will run the second function
    }

    static void func(int a) {
        System.out.println(a);
    }

    static void func(String a) {
        System.out.println(a);
    }
}

/*
 * Function overloading is basically that two or more than two functions exist
 * with the same name but different type of arguments or different number of
 * same type of arguments.
 * 
 * ------------------------------------------------------------
 * 
 * Following is the example of different number of same type of arguments
 * static void func(int a) {
 * System.out.println(a);
 * }
 * 
 * static void func(int a, int b) {
 * System.out.println(a + " " + b);
 * }
 * 
 * ------------------------------------------------------------
 * 
 * And following is the example of different type of arguments
 * 
 * static void func(int a) {
 * System.out.println(a);
 * }
 * 
 * static void func(String a) {
 * System.out.println(a);
 * }
 * 
 * -------------------------------------------------------------
 * The program will automatically determine on the basis of the arguments you
 * are passing that this function call belongs to which function
 * 
 * Function overloading at compile time decided which function to run
 */

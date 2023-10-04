package com.abdullah;

public class Shadowing {
    static int x = 90;

    public static void main(String[] args) {
        func();

        // You can change the value of the variable x
        int x = 40; // Now the class variable at line 4 is shadowed by this

        System.out.println(x); // This will print the new value of x now
    }

    static void func() {
        System.out.println(x);
    }
}

/*
 * Scope begins when the value if initialised
 * When you write the following inside psvm now:
 * int x; // Declaration
 * System.out.println(x);
 * x = 10; // Initialisation
 * 
 * Then this will throw an error as the scope only begins when the value is
 * initialised
 */

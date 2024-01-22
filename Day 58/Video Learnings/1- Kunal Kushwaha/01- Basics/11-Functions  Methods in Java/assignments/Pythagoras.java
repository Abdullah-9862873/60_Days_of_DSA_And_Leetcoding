package com.assignments;

import java.util.Scanner;

public class Pythagoras {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the vaue of a: ");
        int a = input.nextInt();

        System.out.println("Enter the vaue of b: ");
        int b = input.nextInt();

        System.out.println("Enter the vaue of c: ");
        int c = input.nextInt();

        input.close();

        boolean result = isPythagoras(a, b, c);

        if (result) {
            System.out.println("This is a pythagoras triangle");
        } else {
            System.out.println("This is not a pythagoras triangle");
        }
    }

    static boolean isPythagoras(int a, int b, int c) {
        boolean isTrue = false;

        int max = a;
        if (max < b) {
            max = b;
        }
        if (max < c) {
            max = c;
        }

        if (max == a) {
            a = c;
            c = max;
        } else if (max == b) {
            b = c;
            c = max;
        }

        if (a * a + b * b == c * c) {
            isTrue = true;
        }
        return isTrue;
    }
}

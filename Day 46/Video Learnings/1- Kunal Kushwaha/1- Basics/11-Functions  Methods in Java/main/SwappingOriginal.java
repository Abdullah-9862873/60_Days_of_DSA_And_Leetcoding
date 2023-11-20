package com.abdullah;

import java.util.Scanner;

public class SwappingOriginal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter num1: ");
        int num1 = input.nextInt();
        System.out.println("Enter num2: ");
        int num2 = input.nextInt();

        System.out.println("Before swapping the value of num1 is: " + num1 + " and the value of num2 is: " + num2);

        // Swapping both numbers
        int[] swapped = swap(num1, num2);
        num1 = swapped[0];
        num2 = swapped[1];

        System.out.println("After swapping the value of num1 is: " + num1 + " and the value of num2 is: " + num2);

        input.close();
    }

    static int[] swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        return new int[] { a, b };
    }
}

// Write a program to print whether a number is even or odd, also take input from the user.

package com.assignments;

import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        System.out.println("Enter the number: ");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        input.close();
        if (number % 2 == 0 || number == 0) {
            System.out.println("The given number is even");
        } else {
            System.out.println("The given number is odd");
        }
    }
}

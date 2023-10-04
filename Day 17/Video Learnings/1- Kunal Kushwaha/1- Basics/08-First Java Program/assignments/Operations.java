// Take in two numbers and an operator (+, -, *, /) and calculate the value. (Use if conditions)

package com.assignments;

import java.util.Scanner;

public class Operations {
    public static void main(String[] args) {
        System.out.println("Enter the first value: ");
        Scanner input = new Scanner(System.in);
        int firstVal = input.nextInt();

        System.out.println("Enter the second value: ");
        Scanner input2 = new Scanner(System.in);
        int secondVal = input.nextInt();

        input.close();
        input2.close();

        int add = firstVal + secondVal;
        int subtract = 0;

        if (firstVal > secondVal) {
            subtract = firstVal - secondVal;
        } else {
            subtract = secondVal = firstVal;
        }

        int divide = 0;
        if (firstVal > secondVal) {
            divide = firstVal / secondVal;
        } else {
            divide = secondVal / firstVal;
        }

        int multiply = firstVal * secondVal;

        System.out.println(firstVal + " + " + secondVal + " = " + add);
        System.out.println("Subtract = " + subtract);
        System.out.println("Divide = " + divide);
        System.out.println(firstVal + " x " + secondVal + " = " + multiply);

    }
}

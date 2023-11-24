package com.assignments;

import java.util.Scanner;

public class MaxMinNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        int num1 = input.nextInt();

        System.out.println("Enter number 2: ");
        int num2 = input.nextInt();

        System.out.println("Enter number 3: ");
        int num3 = input.nextInt();

        input.close();

        int max = num1;
        if (num2 > max) {
            max = num2;
        } else if (num3 > max) {
            max = num3;
        }

        System.out.println("The maximum of three numbers you entered is: " + max);
    }
}

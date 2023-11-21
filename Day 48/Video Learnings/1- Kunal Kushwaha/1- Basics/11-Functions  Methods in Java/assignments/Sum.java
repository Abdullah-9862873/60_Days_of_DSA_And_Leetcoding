package com.assignments;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int firstNumber = input.nextInt();

        System.out.println("Enter the second number: ");
        int secondNumber = input.nextInt();

        input.close();

        int result = sum(firstNumber, secondNumber);

        System.out.println("The sum of " + firstNumber + " and " + secondNumber + " is: " + result);
    }

    static int sum(int num1, int num2) {
        int sum;
        sum = num1 + num2;

        return sum;
    }
}

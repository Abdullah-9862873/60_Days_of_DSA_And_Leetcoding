// Given an integer number n, return the difference between the product of its digits and the sum of its digits.

// Check example---> num = 4421 ----> Ans should be (32-11 = 21)

package com.assignments;

import java.util.Scanner;

public class LeetCodeQuestion {
    public static void main(String[] args) {
        System.out.println("Enter the number: ");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();

        int initialNumberForSum = userInput;
        int initialNumber = userInput;
        // Calculating the product
        int initialNumberRem = 0;
        int initialNumberAns = 1;

        while (initialNumber != 0) {
            initialNumberRem = initialNumber % 10;
            initialNumberAns = initialNumberAns * initialNumberRem;
            initialNumber = initialNumber / 10;
        }
        int product = initialNumberAns;

        // Calculating the Sum
        int sumRem = 0;
        int sumAns = 0;

        while (initialNumberForSum != 0) {
            sumRem = initialNumberForSum % 10;
            sumAns = sumAns + sumRem;
            initialNumberForSum = initialNumberForSum / 10;
        }
        int sum = sumAns;

        // Differentiating the sum and product
        int finalAns = product - sum;
        System.out.println("Product - Sum = " + finalAns);

        input.close();
    }
}

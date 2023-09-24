// Find if a number is palindrome or not
// 2002 is a palindrome
package com.assignments;

import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println("Enter the number: ");
        Scanner input = new Scanner(System.in);

        int userInput = input.nextInt();
        int straightNumber = userInput;
        int rem = 0;
        int reverseNumber = 0;

        while (straightNumber != 0) {
            rem = straightNumber % 10;
            reverseNumber = reverseNumber * 10 + rem;
            straightNumber = straightNumber / 10;
        }

        if (userInput == reverseNumber) {
            System.out.println("The given number is a palindrome");
        } else {
            System.out.println("The given number is not a palindrome");
        }

        input.close();
    }
}

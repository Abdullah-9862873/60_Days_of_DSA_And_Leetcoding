package com.assignments;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the num: ");
        int userInput = input.nextInt();

        input.close();

        boolean result = isPalindrome(userInput);

        if (result) {
            System.out.println("The number you entered is a palindrome");
        } else {
            System.out.println("The number you entered is not a palindrome");
        }
    }

    static boolean isPalindrome(int num) {
        boolean palindrome = false;
        int rem = 0;
        int reverseNumber = 0;
        int userInput = num;

        while (userInput != 0) {
            rem = userInput % 10;
            reverseNumber = reverseNumber * 10 + rem;
            userInput = userInput / 10;
        }
        if (reverseNumber == num) {
            palindrome = true;
        }

        return palindrome;
    }
}

// Reverse a number

package com.abdullah;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println("Enter the number: ");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();
        input.close();

        // int result = 0;
        // while (userInput != 0) {
        // result += userInput % 10;
        // result = result * 10;
        // userInput = userInput / 10;
        // }
        // result = result / 10;
        // System.out.println(result);

        int ans = 0;
        int rem = 0;

        while (userInput > 0) {
            rem = userInput % 10;
            userInput = userInput / 10;
            ans = ans * 10 + rem;
        }

        System.out.println(ans);
    }
}
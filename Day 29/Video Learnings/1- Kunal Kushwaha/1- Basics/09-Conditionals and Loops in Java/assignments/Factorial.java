package com.assignments;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("Enter the number you want to find the factorial of: ");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();
        int ans = userInput;

        if (userInput == 0 || userInput == 1) {
            ans = 1;
        } else {
            for (int i = userInput - 1; i >= 1; i--) {
                ans = ans * i;
            }
        }
        System.out.println("The factorial of " + userInput + " is: " + ans);
        input.close();
    }
}

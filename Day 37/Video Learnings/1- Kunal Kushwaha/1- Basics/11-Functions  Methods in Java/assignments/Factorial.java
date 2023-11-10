package com.assignments;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int userInput = input.nextInt();

        input.close();

        int result = factorial(userInput);

        System.out.println("The factorial of " + userInput + " is: " + result);
    }

    static int factorial(int num) {
        int result = 1;
        if (num == 0 || num == 1) {
            result = 1;
        } else {
            for (int i = 1; i <= num; i++) {
                result = result * i;
            }
        }

        return result;
    }
}

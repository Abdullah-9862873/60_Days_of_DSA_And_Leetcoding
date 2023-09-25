// To calculate Fibonacci Series up to n numbers.
package com.assignments;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("Enter the number you want the fibonacci series upto: ");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();

        int start = 3;
        int num1 = 0;
        int num2 = 1;
        int next = num1 + num2;

        // 0, 1, 1,

        System.out.print(num1 + " ");
        System.out.print(num2 + " ");
        while (start <= userInput) {
            System.out.print(next + " ");
            num1 = num2;
            num2 = next;
            next = num1 + num2;
            start++;
        }
        input.close();
    }

}

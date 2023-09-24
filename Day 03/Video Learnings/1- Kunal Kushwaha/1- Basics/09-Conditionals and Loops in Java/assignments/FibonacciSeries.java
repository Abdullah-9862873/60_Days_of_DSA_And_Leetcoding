package com.assignments;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println("Enter the limit of fibonacci series: ");
        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();

        input.close();

        int num1 = 0;
        int num2 = 1;
        int next = num1 + num2;

        int start = 3;

        System.out.print(num1 + ", ");
        System.out.print(num2 + ", ");
        while (start <= userInput) {
            System.out.print(next + ", ");
            num1 = num2;
            num2 = next;
            next = num1 + num2;
            start++;
        }
    }

}

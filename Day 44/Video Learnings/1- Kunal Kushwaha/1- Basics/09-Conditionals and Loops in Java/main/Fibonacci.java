// package com.abdullah;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int next = a + b;
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        input.close();
        int start = 4;

        while (start <= num) {
            a = b;
            b = next;
            next = a + b;
            start++;
        }
        System.out.println("The " + num + "th " + "fibonacci value is: " + next);
    }
}

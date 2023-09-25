// Write a program to input principal, time, and rate (P, T, R) from the user and find Simple Interest.

package com.assignments;

import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        int simpleInterest = 0;

        System.out.println("Enter the value of P (Principal): ");
        Scanner input = new Scanner(System.in);
        int principal = input.nextInt();

        System.out.println("Enter the value of T (Time): ");
        Scanner input2 = new Scanner(System.in);
        int time = input2.nextInt();

        System.out.println("Enter the value of R (Rate): ");
        Scanner input3 = new Scanner(System.in);
        int rate = input3.nextInt();

        simpleInterest = (principal * time * rate);
        System.out.println("The value of Simple Interest is: " + simpleInterest);

        input.close();
        input2.close();
        input3.close();
    }
}

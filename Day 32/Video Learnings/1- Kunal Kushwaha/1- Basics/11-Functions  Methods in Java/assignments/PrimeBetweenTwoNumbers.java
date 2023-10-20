package com.assignments;

import java.util.Scanner;

public class PrimeBetweenTwoNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter first number: ");
        int num1 = input.nextInt();

        System.out.println("Enter second number: ");
        int num2 = input.nextInt();

        input.close();

        String result = primeNumbers(num1, num2);

        System.out.println(result);
    }

    static String primeNumbers(int num1, int num2) {
        String result = "";

        for (int i = num1; i <= num2; i++) {

            boolean flag = true;

            if (i == 0 || i == 1) {
                continue;
            }

            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result = result + i + " ";
            }
        }
        return result;
    }
}
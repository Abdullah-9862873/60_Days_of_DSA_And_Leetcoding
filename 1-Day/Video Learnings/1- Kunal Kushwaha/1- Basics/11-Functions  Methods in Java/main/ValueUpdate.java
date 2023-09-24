package com.abdullah;

import java.util.Scanner;

public class ValueUpdate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of num1: ");
        int num1 = input.nextInt();

        System.out.println("Enter the value of num2: ");
        int num2 = input.nextInt();

        System.out.println("Before Updation: " + num1 + ", " + num2);

        int[] inputArr = { num1, num2 };

        update(inputArr);

        // Updation
        num1 = inputArr[0];
        num2 = inputArr[1];

        System.out.println("After updation: " + num1 + ", " + num2);

        input.close();
    }

    static void update(int[] arr) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter new value for num1: ");
        int newNum1 = input.nextInt();

        System.out.println("Enter new value for num2: ");
        int newNum2 = input.nextInt();

        arr[0] = newNum1;
        arr[1] = newNum2;
        input.close();
    }
}

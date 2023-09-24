package com.abdullah;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        System.out.println("Enter the first value: ");
        Scanner input1 = new Scanner(System.in);
        int value1 = input1.nextInt();
        System.out.println("Enter the second value: ");
        Scanner input2 = new Scanner(System.in);
        int value2 = input2.nextInt();
        int sum = value1 + value2;
        System.out.println("The sum of " + value1 + " and " + value2 + " is: " + sum);
        input1.close();
        input2.close();
    }

}

// Take 2 numbers as input and print the largest number.

package com.assignments;

import java.util.Scanner;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println("Enter the first Value: ");
        Scanner input = new Scanner(System.in);
        int firstVal = input.nextInt();

        System.out.println("Enter the second Value: ");
        Scanner input2 = new Scanner(System.in);
        int secondVal = input.nextInt();

        if (firstVal > secondVal) {
            System.out.println("The largest number is: " + firstVal);
        } else {
            System.out.println("The largest number is: " + secondVal);
        }

        input.close();
        input2.close();
    }
}

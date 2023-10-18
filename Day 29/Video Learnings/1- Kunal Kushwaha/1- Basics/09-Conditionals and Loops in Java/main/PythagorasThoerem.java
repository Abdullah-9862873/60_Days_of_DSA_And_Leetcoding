package com.abdullah;

import java.util.Scanner;

public class PythagorasThoerem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first value: ");
        int firstVal = input.nextInt();
        System.out.println("Enter the second value: ");
        int secondVal = input.nextInt();
        System.out.println("Enter the third value: ");
        int thirdVal = input.nextInt();
        input.close();

        // Finding the maximum value of the given three
        int max = 0;
        max = (Math.max(firstVal, secondVal));
        max = Math.max(max, thirdVal);

        // Putting the maximum value in third one
        int a, b, c = 0;

        if (firstVal == max) {
            a = secondVal;
            b = thirdVal;
            c = firstVal;
        } else if (secondVal == max) {
            a = thirdVal;
            b = firstVal;
            c = secondVal;
        } else {
            a = firstVal;
            b = secondVal;
            c = thirdVal;
        }

        // Checking if it is pythagoras c^2 = a^2 + b^2
        if ((Math.pow(a, 2) + Math.pow(b, 2)) == Math.pow(c, 2)) {
            System.out.println("It holds phythagoras theorem");
        } else {
            System.out.println("It does not holds phythagoras theorem");
        }
    }
}
package com.abdullah;

import java.util.Scanner;

public class TriangleProblem {
    public static void main(String[] args) {
        System.out.println("Enter the value of first side of triangle: ");
        Scanner input = new Scanner(System.in);
        int firstSide = input.nextInt();
        System.out.println("Enter the value of second side of triangle: ");
        int secondSide = input.nextInt();
        System.out.println("Enter the value of third side of triangle: ");
        int thirdSide = input.nextInt();
        input.close();

        boolean isTrue = true;

        if ((firstSide + secondSide) <= thirdSide) {
            isTrue = false;
        } else if ((secondSide + thirdSide) <= firstSide) {
            isTrue = false;
        } else if ((firstSide + thirdSide) <= secondSide) {
            isTrue = false;
        }

        if (isTrue) {
            System.out.println("It is a valid triangle");
        } else {
            System.out.println("It is not a valid triangle");
        }

    }
}

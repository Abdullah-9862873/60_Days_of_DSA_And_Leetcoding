package com.assignments;

import java.util.Scanner;

public class AreaOfEquilateralTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b, c = 0;
        System.out.println("Checking if the triangle is an equilateral triangle or not!!!");
        System.out.println("Enter the value of first side of triangle: ");
        a = input.nextInt();
        System.out.println("Enter the value of second side of triangle: ");
        b = input.nextInt();
        System.out.println("Enter the value of third side of triangle: ");
        c = input.nextInt();

        boolean isEquilateral = false;

        if (a == b && b == c) {
            System.out.println("Yes it is an Equilateral Triangle");
            isEquilateral = true;
        }

        if (isEquilateral) {
            System.out.println("The area of this triangle is: " + (Math.sqrt(3) / 4) * (a * a));
        } else {
            System.out.println("It is not an equilateral triangle");
        }
        input.close();
        System.out.println((0.5) * 3);
    }
}

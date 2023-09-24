// Find the area of isosceles triangle
package com.assignments;

import java.util.Scanner;

public class AreaOfIsoscelesTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b, c = 0;
        System.out.println("Checking if the triangle is IsoSceles or not!!!");
        System.out.println("Enter the value of first side: ");
        a = input.nextInt();
        System.out.println("Enter the value of second side: ");
        b = input.nextInt();
        System.out.println("Enter the value of third side: ");
        c = input.nextInt();

        boolean isIsosceles = false;
        if (a == b) {
            isIsosceles = true;
        } else if (b == c) {
            isIsosceles = true;
        } else if (c == a) {
            isIsosceles = true;
        }
        if (isIsosceles) {
            System.out.println("Yes it is an isosceles triangle");
        }
        System.out.println("Now enter the following values to calculate the area: ");
        if (isIsosceles) {
            System.out.println("Base value: ");
            int base = input.nextInt();
            System.out.println("Height value: ");
            int height = input.nextInt();

            System.out.println("The area of this isosceles triangle is: " + (0.5 * base * height));
        } else {
            System.out.println("It is not an IsoSceles triangle");
        }
        input.close();
    }
}

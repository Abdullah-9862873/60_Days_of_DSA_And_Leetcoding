// Find the area of triangle
package com.assignments;

import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the base value: ");
        int base = input.nextInt();
        System.out.println("Enter the height value: ");
        int height = input.nextInt();

        System.out.println("The area of triangle is: " + (0.5 * base * height));
        input.close();
    }

}

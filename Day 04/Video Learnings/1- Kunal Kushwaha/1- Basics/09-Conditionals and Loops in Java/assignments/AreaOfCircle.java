// Find the area of circle

package com.assignments;

import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        System.out.println("Enter the value of radius of circle");
        Scanner input = new Scanner(System.in);
        int radius = input.nextInt();
        radius = radius * radius;
        System.out.println("The area of circle is: " + (3.14 * radius));
        input.close();
    }
}

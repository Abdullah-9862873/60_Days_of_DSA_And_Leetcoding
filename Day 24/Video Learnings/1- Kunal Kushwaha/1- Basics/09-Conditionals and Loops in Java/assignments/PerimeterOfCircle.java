package com.assignments;

import java.util.Scanner;

public class PerimeterOfCircle {
    public static void main(String[] args) {
        System.out.println("Enter the value of radius: ");
        Scanner input = new Scanner(System.in);
        int radius = input.nextInt();

        System.out.println("The perimeter of given circle is: " + (2 * (3.14) * radius));
        input.close();
    }
}
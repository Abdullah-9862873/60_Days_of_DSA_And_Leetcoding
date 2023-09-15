package com.assignments;

import java.util.Scanner;

public class AreaOfRectangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of length of rectangle: ");
        int length = input.nextInt();
        System.out.println("Enter the value of width: ");
        int width = input.nextInt();
        input.close();

        System.out.println("The area of rectangle is: " + (length * width));

    }
}

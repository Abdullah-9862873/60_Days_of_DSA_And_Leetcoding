package com.assignments;

import java.util.Scanner;

public class AreaOfRhombus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length of diagonal 1: ");
        int diagonal1 = input.nextInt();
        System.out.println("Enter the length of diagonal 2: ");
        int diagonal2 = input.nextInt();
        input.close();

        System.out.println("The area of rhombus is: " + (0.5 * (diagonal1 * diagonal2)));

    }
}

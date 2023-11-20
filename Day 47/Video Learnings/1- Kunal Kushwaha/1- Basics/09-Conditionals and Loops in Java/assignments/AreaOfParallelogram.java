package com.assignments;

import java.util.Scanner;

public class AreaOfParallelogram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the value of base: ");
        int base = input.nextInt();
        System.out.println("Enter the value of height: ");
        int height = input.nextInt();
        input.close();

        System.out.println("The area of parallelogram is: " + (base * height));
    }
}

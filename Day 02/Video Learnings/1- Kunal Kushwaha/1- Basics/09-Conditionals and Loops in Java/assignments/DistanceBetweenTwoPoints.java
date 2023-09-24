// I want the output The distance between (1,1) and (9,9) is: 11.313708498984761
package com.assignments;

import java.util.Scanner;

public class DistanceBetweenTwoPoints {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the value of x1: ");
        int x1 = input.nextInt();

        System.out.println("Enter the value of y1: ");
        int y1 = input.nextInt();

        System.out.println("Enter the value of x2: ");
        int x2 = input.nextInt();

        System.out.println("Enter the value of y2: ");
        int y2 = input.nextInt();

        double distance = Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
        System.out.println("The distance between (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ") is: " + distance);

        input.close();
    }
}

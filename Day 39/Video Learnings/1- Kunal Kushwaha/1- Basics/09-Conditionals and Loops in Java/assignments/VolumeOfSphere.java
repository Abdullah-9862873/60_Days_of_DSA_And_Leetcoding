package com.assignments;

import java.util.Scanner;

public class VolumeOfSphere {
    public static void main(String[] args) {
        System.out.println("Enter the value of radius of sphere: ");
        Scanner input = new Scanner(System.in);
        int radius = input.nextInt();

        double pie = 3.14285714286;
        double volume = 4.0 / 3.0 * pie * Math.pow(radius, 3);
        System.out.println("The volume of sphere is: " + volume);
        input.close();
    }
}

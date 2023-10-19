package com.assignments;

import java.util.Scanner;

public class VolumeOfCone {
    public static void main(String[] args) {
        System.out.println("Enter the value of radius: ");
        Scanner input = new Scanner(System.in);
        int radius = input.nextInt();

        System.out.println("Enter the value of height: ");
        int height = input.nextInt();

        input.close();
        double pie = 3.14285714286;
        double volume = pie * (radius * radius) * height / 3;
        System.out.println("The volume of given cone is: " + volume);

    }
}

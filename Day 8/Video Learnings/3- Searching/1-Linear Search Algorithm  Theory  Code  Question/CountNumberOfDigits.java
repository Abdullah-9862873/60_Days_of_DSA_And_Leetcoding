package com.main;
import java.util.Scanner;

public class CountNumberOfDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number you want to find the length of: ");

        int val = input.nextInt();

        int len = (int) Math.log10(val) + 1;
        System.out.println(len);
        input.close();
    }
}

package com.abdullah;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Enter the salary: ");
        // Scanner input = new Scanner(System.in);
        // int salary = input.nextInt();
        // if (salary > 10000) {
        // salary += 2000;
        // } else {
        // salary += 1000;
        // }
        // input.close();
        // System.out.println("Your salary after bonus is: " + salary);

        // Print numbers from 1 to 5
        // int i = 1;
        // while (i <= 5) {
        // System.out.println(i);
        // i++;
        // }

        // Print numbers from 1 to n
        // System.out.println("Enter the limit your want your numbers to be upto:");
        // Scanner input = new Scanner(System.in);
        // int userVal = input.nextInt();
        // input.close();
        // for (int i = 1; i <= userVal; i++) {
        // System.out.println(i);
        // }

        // Print numbers from 1 to n using while loop
        // int i = 1;
        // while (i <= 5) {
        // System.out.println(i);
        // i++;
        // }

        // Find the largest of three numbers
        // System.out.println("Enter the numbers");
        // Scanner input = new Scanner(System.in);
        // int a = input.nextInt();
        // int b = input.nextInt();
        // int c = input.nextInt();

        // Method 2
        // int max = 0;
        // if (a > b) {
        // max = a;
        // } else {
        // max = b;
        // }

        // if (c > max) {
        // max = c;
        // }

        // Method 3
        // int max = Math.max(Math.max(a, b), c);

        // System.out.println("The maximum number is: " + max);

        // Scanner input = new Scanner(System.in);
        // String str = input.nextLine().trim();
        // char ch = input.next().trim().charAt(0);
        // input.close();
        // System.out.println(ch);

        // Check whether the user entered a character in lower alphabets or not
        Scanner input = new Scanner(System.in);
        char ch = input.next().trim().charAt(0);
        if (ch >= 'a' && ch <= 'z') {
            System.out.println("The character you typed is in lower case");
        } else if (ch >= 'A' && ch <= 'Z') {
            System.out.println("The character you typed is in Upper case");
        }
        input.close();
    }
}
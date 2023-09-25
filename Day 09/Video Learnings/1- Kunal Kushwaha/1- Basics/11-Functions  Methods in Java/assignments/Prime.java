package com.assignments;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int userInput = input.nextInt();

        input.close();

        boolean result = isPrime(userInput);

        if (result) {
            System.out.println("The number you entered is prime");
        } else {
            System.out.println("The number you entered is not prime");
        }
    }

    static boolean isPrime(int num) {

        boolean prime = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                prime = false;
            }
        }

        return prime;
    }

}
